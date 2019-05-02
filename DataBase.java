import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import java.io.*;
/**
 * The database that stores the news article and the terms in them.
 * @author Ji Xiayan
 *
 */
public class DataBase implements IDataBase {
	// A list of words that is meaningless and filtered out when constructing the database.
	Set<String> stoppedList = new HashSet<>();
	// Default number for maximum heap.
	final int MAX_HEAP_NUM = 100;
	// Stores each keyword and the corresponding heap of news articles.
	HashMap<String, MaxHeap> db;
	// Stores all the term in the data base with the number of news that contain
	// them.
	HashMap<String, Integer> allTermMap;
	// Stores news and the frequency for each term in the news.
	HashMap<FeedMessage, HashMap<String, Integer>> feedMessageMap;
	// Number of total news articles in the database.
	int dbSize = 0;

	/**
	 * Getter for stopped list.
	 * 
	 * @return A list of words that is filtered out in the database.
	 */
	public Set<String> getStoppedList() {
		return stoppedList;
	}

	/**
	 * Getter for the db map.
	 * 
	 * @return db A map storing each keyword and the corresponding heap of news
	 *         articles.
	 */
	public HashMap<String, MaxHeap> getDb() {
		return db;
	}

	/**
	 * Getter for the database size.
	 * 
	 * @return dbSize Number of total news articles in the database.
	 */
	public int getDbSize() {
		return dbSize;
	}

	/**
	 * Getter for the allTermMap.
	 * @return allTermMap A map storing all the term in the data base with the number of news that contain them.
	 */
	public HashMap<String, Integer> getAllTermMap() {
		return allTermMap;
	}
	/**
	 * Getter for feedMessageMap.
	 * @return feedMessageMap A map storing all the news and the frequency for each term in the news.
	 */
	public HashMap<FeedMessage, HashMap<String, Integer>> getFeedMessageMap() {
		return feedMessageMap;
	}

	/**
	 * Constructor of a database.
	 */
	public DataBase() {
		db = new HashMap<>();
		allTermMap = new HashMap<>();
		feedMessageMap = new HashMap<>();

	}

	/**
	 * Initialize a stop list to filter out the meaningless word.
	 * 
	 * @throws FileNotFoundException
	 */
	@Override
	public void initStopList() throws FileNotFoundException {
		File input = new File("stop-list.txt");
		Scanner sc = new Scanner(input);
		while (sc.hasNextLine()) {
			String s = sc.nextLine().trim();
			stoppedList.add(s);
		}
		stoppedList.remove("the");
	}
	/**
	 * Update the database so that the db Map maps each keyword to a heap of new articles.
	 */
	@Override
	public void updateDataBase() {
		if (feedMessageMap == null)
			throw new IllegalArgumentException("Storing failed! FeedMessageMap is null!");
		for (FeedMessage msg : feedMessageMap.keySet()) {
			if (msg == null)
				continue;
			msg.calculateTFIDFScore(this);
			HashMap<String, Double> map = msg.getMap();
			for (String s : map.keySet()) {
				MaxHeap heap = null;
				if (stoppedList.contains(s) || s.length() <= 0) {
					continue;
				}
				if (db.keySet().contains(s)) {
					heap = db.get(s);

				} else {
					heap = new MaxHeap(MAX_HEAP_NUM, s);
				}
				heap.insert(msg);
				db.put(s, heap);

			}
		}
	}
	/**
	 * Fetch the news related to the keyword in the database
	 * @param keyWord the keyword of interest
	 * @return a list of new related to this topic
	 */
	@Override
	public List<FeedMessage> fetch(String keyWord) {
		if (!db.keySet().contains(keyWord))
			return null;
		ArrayList<FeedMessage> res = new ArrayList<>();
		for (String e : db.keySet()) {
			if (e.equals(keyWord)) {
				// keyword found, return the maxHeap in the form of a list
				MaxHeap heap = db.get(e);
				res = heap.toList();
			}
		}
		return res;
	}
	/**
	 * Store all news from a new web site URL(e.g. CNN) into the database.
	 * @param feed all news from a particular news source.
	 * @return the number of news successfully stored
	 */
	@Override
	public int store(Feed feed) {
		if (feed == null)
			return -1;
		List<FeedMessage> msgList = feed.getMessages();

		for (FeedMessage msg : msgList) {

			String text = msg.getNewsText();
			if (text == null)
				continue;
			String[] arr = text.split("[^a-zA-Z]+");
			for (String s : arr) {
				s = s.trim().toLowerCase();
				if (!stoppedList.contains(s)) {
					HashMap<String, Integer> tempMap = null;
					if (feedMessageMap.containsKey(msg)) {
						tempMap = feedMessageMap.get(msg);
					} else {
						tempMap = new HashMap<>();
					}
					tempMap.put(s, tempMap.getOrDefault(s, 0) + 1);
					feedMessageMap.put(msg, tempMap);
					allTermMap.put(s, allTermMap.getOrDefault(s, 0) + 1);
				}
			}

		}
		dbSize += feed.getMessages().size();
		updateDataBase();
		return feed.getMessages().size();
	}

}
