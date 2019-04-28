import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java.io.*;

public class DataBase implements IDataBase {
	Set<String> stoppedList  = new HashSet<>();
	final int MAX_HEAP_NUM = 100;
	HashMap<String, MaxHeap> db;
	int dbSize = 0;
	public Set<String> getStoppedList() {
		return stoppedList;
	}

	public HashMap<String, MaxHeap> getDb() {
		return db;
	}

	public int getDbSize() {
		return dbSize;
	}

	public HashMap<String, Integer> getAllTermMap() {
		return allTermMap;
	}

	public HashMap<FeedMessage, HashMap<String, Integer>> getFeedMessageMap() {
		return feedMessageMap;
	}

	HashMap<String, Integer> allTermMap;
	HashMap<FeedMessage, HashMap<String, Integer>> feedMessageMap;
	public DataBase() {
		db = new HashMap<>();
		allTermMap = new HashMap<>();
		feedMessageMap = new HashMap<>();
	}	
	
	public void initStopList() throws FileNotFoundException {
		File input = new File("../stoppedlist");
		Scanner sc = new Scanner(input);
		while (sc.hasNextLine());
		String s = sc.nextLine().trim();
		stoppedList.add(s);
	}

	@Override
	public List<FeedMessage> fetch(String keyWord) {
		// TODO Auto-generated method stub
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

	@Override
	public int store(Feed feed) {
		// TODO Auto-generated method stub
		if (feed == null)
			return -1;
		List<FeedMessage> msgList = feed.getMessages();

		for (FeedMessage msg : msgList) {
			HashMap<String, Double> map = msg.getMap();
			for (String s : map.keySet()) {
				MaxHeap heap = null;
				if (stoppedList.contains(s)) {
					continue;
				}
				if (db.keySet().contains(s)) {
					heap = db.get(s);

				} else {
					FeedMessage[] h = { msg };
					heap = new MaxHeap(h, h.length, MAX_HEAP_NUM, s);
				}
				heap.insert(msg);
				db.put(s, heap);

			}
			String text = msg.getNewsText();
			String[] arr = text.split("[^a-zA-Z]+");
			for (String s : arr) {
				s = s.trim();
				if (!stoppedList.contains(s)) {
					HashMap<String, Integer> tempMap = null;
					if (feedMessageMap.containsKey(msg)) {
						tempMap = feedMessageMap.get(msg);
					} else {
						tempMap = new HashMap<>();
					}
					tempMap.put(s, tempMap.getOrDefault(s, 0)+1);
					feedMessageMap.put(msg, tempMap);
					allTermMap.put(s, allTermMap.getOrDefault(s, 0) +1);
				}
			}
		}
		dbSize += feed.getMessages().size();
		return feed.getMessages().size();
	}

}
