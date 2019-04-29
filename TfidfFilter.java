import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TfidfFilter implements ITfidfFilter {
	class info {
		String keyword;
		Double score;
		info (String k, Double s) {
			keyword = k;
			score = s;
		}
	}

	@Override
	public HashMap<String, Double> calculateTfidf(DataBase db, FeedMessage msg) {
		// TODO Auto-generated method stub
		PriorityQueue<info> pq = new PriorityQueue<info>(10, (a, b) -> b.score.compareTo(a.score));
		Map<String, Integer> wordCountMap = db.getFeedMessageMap().get(msg);
		int total_doc = db.getDbSize();
		int docSize = 0;
		for (String s: wordCountMap.keySet()) {
			docSize += wordCountMap.get(s);
		}
		for (String s: wordCountMap.keySet()) {
			double tf = (double) wordCountMap.get(s) / docSize;
			double idf = Math.log((double) total_doc / db.getAllTermMap().get(s));
			Double score = tf * idf;
			info temp = new info(s, score);
			pq.offer(temp);
		}
		HashMap<String, Double> ret = new HashMap<>();
		for (int i = 0; i < 10; i++ ) {
			info temp = pq.poll();
			ret.put(temp.keyword, temp.score);
		}
		return ret;
	}	
}
