import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import java.io.*;

public class DataBase implements IDataBase {
	Set<String> stoppedList  = new HashSet<>();
	final int MAX_HEAP_NUM = 100;
	HashMap<String, MaxHeap> db;
	// stores all the term in the data base with the number of news that contains them
	HashMap<String, Integer> allTermMap;
	// store news and the tf-idf socre for each term in the news
	HashMap<FeedMessage, HashMap<String, Integer>> feedMessageMap;
	HashMap<String, Set<FeedMessage>> wordMap;
	int dbSize = 0;
	public Set<String> getStoppedList() {
		return stoppedList;
	}
	public HashMap<String, Set<FeedMessage>> getWordMap(){
		return wordMap;
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

	
	public DataBase() {
		db = new HashMap<>();
		allTermMap = new HashMap<>();
		feedMessageMap = new HashMap<>();
		wordMap = new HashMap<>();
	}	
	
	public void initStopList() throws FileNotFoundException {
		File input = new File("stop-list.txt");
		Scanner sc = new Scanner(input);
		while (sc.hasNextLine()) {
		String s = sc.nextLine().trim();
		stoppedList.add(s);
		}
		stoppedList.remove("the");
	}
	public void updateDataBase() {
		for (FeedMessage msg: feedMessageMap.keySet()) {
			msg.calculateTFIDFScore(this);
		}
		if(feedMessageMap == null) throw new IllegalArgumentException("Storing failed! FeedMessageMap is null!"); 
		for (FeedMessage msg : feedMessageMap.keySet()) {
			HashMap<String, Double> map = msg.getMap();
//			System.out.println("__________________");
//			System.out.println(map);
//			System.out.println("__________________");
//			System.out.println("__________________");
//			System.out.println(wordMap);
//			System.out.println("__________________");
			for (String s : map.keySet()) {
//				System.out.println(s);
				if (wordMap.containsKey(s)) {
					System.out.println("Already in the map");
				}
				Set<FeedMessage> temp = wordMap.getOrDefault(s, new HashSet<>());
				temp.add(msg);
				if (temp.size() > 1) {
					System.out.println("This appears more than once" + s);
				}
				wordMap.put(s,  temp);
			}
		}
//		for (String s: wordMap.keySet()) {
//			System.out.println(s);
//			System.out.println(wordMap.get(s).size());
//		}
	}
//	public void updateDataBase() {
//		if(feedMessageMap == null) throw new IllegalArgumentException("Storing failed! FeedMessageMap is null!"); 
//		for (FeedMessage msg : feedMessageMap.keySet()) {
//			msg.calculateTFIDFScore(this);
//			HashMap<String, Double> map = msg.getMap();
//			for (String s : map.keySet()) {
//				MaxHeap heap = null;
//				if (stoppedList.contains(s) || s.length() <= 0) {
//					continue;
//				}
//				if (db.keySet().contains(s)) {
//					heap = db.get(s);
//
//				} else {
////					FeedMessage[] h = { msg };
//					heap = new MaxHeap(MAX_HEAP_NUM, s);
//				}
//				heap.insert(msg);
//				db.put(s, heap);
//
//			}
//		}
//	}

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
//			HashMap<String, Double> map = msg.getMap();
//			for (String s : map.keySet()) {
//				MaxHeap heap = null;
//				if (stoppedList.contains(s)) {
//					continue;
//				}
//				if (db.keySet().contains(s)) {
//					heap = db.get(s);
//
//				} else {
//					FeedMessage[] h = { msg };
//					heap = new MaxHeap(h, h.length, MAX_HEAP_NUM, s);
//				}
//				heap.insert(msg);
//				db.put(s, heap);
//
//			}
			String text = msg.getNewsText();
			if(text == null) continue;
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
					tempMap.put(s, tempMap.getOrDefault(s, 0)+1);
					feedMessageMap.put(msg, tempMap);
					allTermMap.put(s, allTermMap.getOrDefault(s, 0) +1);
				}
			}
//			for (FeedMessage fm: feedMessageMap.keySet()) {
//				Map<String, Integer> temp = feedMessageMap.get(fm);
//				System.out.println("This is another one");
//				for (String str: temp.keySet()) {
//					System.out.println(str + " " + temp.get(str));
//				}
//			}
		}
		dbSize += feed.getMessages().size();
		updateDataBase(); 
		return feed.getMessages().size();
	}

}
