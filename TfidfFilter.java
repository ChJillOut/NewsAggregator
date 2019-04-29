import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TfidfFilter implements ITfidfFilter {
	class info implements Comparable{
		String keyword;
		Double score;
		info (String k, Double s) {
			keyword = k;
			score = s;
		}
		@Override
		public int compareTo(Object a) {
			info b = (info) a; 
			if (this.score < b.score) return -1;
			else if (this.score > b.score) return 1;
			return 0;
		}
		
	}

	@Override
	public HashMap<String, Double> calculateTfidf(DataBase db, FeedMessage msg) {
		// TODO Auto-generated method stub
//		PriorityQueue<info> pq = new PriorityQueue<info>((a, b) -> b.score.compareTo(a.score));
		TreeSet<info> set = new TreeSet<>();
		Map<String, Integer> wordCountMap = db.getFeedMessageMap().get(msg);
		int total_doc = db.getDbSize();
		int docSize = 0;
		for (String s: wordCountMap.keySet()) {
			docSize += wordCountMap.get(s);
		}
		for (String s: wordCountMap.keySet()) {
			if (s == null) continue;
			double tf = (double) wordCountMap.get(s) / docSize;
			double idf = Math.log((double) total_doc / db.getAllTermMap().get(s));
			Double score = tf * idf;
			info temp = new info(s, score);
			set.add(temp);
//			pq.offer(temp);
		}
		HashMap<String, Double> ret = new HashMap<>();
//		for (int i = 0; i < pq.size(); i++ ) {
//			info temp = pq.poll();
//			ret.put(temp.keyword, temp.score);
//		}
		for (int i = 0; i < set.size(); i++ ) {
			info temp = set.pollFirst();
			if (temp == null) continue;
			ret.put(temp.keyword, temp.score);
		}
		return ret;
	}	
}
