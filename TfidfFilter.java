import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TfidfFilter implements ITfidfFilter {
	Map<FeedMessage, PriorityQueue> map = new HashMap<>();
	class info {
		String keyword;
		double score;
		info(String k, double s){
			keyword = k;
			score = s;
		}
	}

	@Override
	public HashMap<String, Double> calculateTfidf(DataBase db, FeedMessage msg) {
		// TODO Auto-generated method stub
		PriorityQueue<info> pq = new pq<>(10, (a, b) -> b.score - a.score);
		Map<String, Integer> wordCountMap = db.getFeedMessageMap().get(msg);
		int total_doc = db.getDbSize();
		int docSize = 0;
		for (String s: wordCountMap.keySet()) {
			docSize += wordCountMap.get(s);
		}
		for (String s: wordCountMap.keySet()) {
			double tf = (double) wordCountMap.get(s) / docSize;
			double idf = Math.log((double) total_doc / db.getAllTermMap().get(s));
			double score = tf * idf;
			info temp = new info(s, score);
			pq.add(temp);
		}
		HashMap<String, Double> ret = new HashMap<>();
		for (int i = 0; i < 10; i++ ) {
			info temp = pq.poll();
			ret.put(temp.keyword, temp.score);
		}
		return ret;
	}

	
}
