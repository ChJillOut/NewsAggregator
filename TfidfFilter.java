import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Interface for TF-IDF filter that calculate the TF-IDF score for each news
 * article based on the database.
 * 
 * @author Nam Vu
 *
 */
public class TfidfFilter implements ITfidfFilter {
	/**
	 * class info stores the keyword and its TFIDF score.
	 * @author Ji Xiayan
	 *
	 */
	class info implements Comparable {
		String keyword;// The key word.
		Double score;// The TF-IDF score.
		/**
		 * constructor of info.
		 * @param k
		 * @param s
		 */
		info(String k, Double s) {
			keyword = k;
			score = s;
		}
		/**
		 * CompareTo method for info, comparing based on the score.
		 */
		@Override
		public int compareTo(Object a) {
			info b = (info) a;
			if (this.score < b.score)
				return -1;
			else if (this.score > b.score)
				return 1;
			return 0;
		}

	}

	@Override
	/**
	 * With this method, we can calculate the TF-IDF value of a news, returning the 
	 * top 10 relatively frequent words and their corresponding TF-IDF value.
	 * @param db
	 * @param msg
	 * @return a hash map recording the 10 words with highest TF-IDF value and the corresponding TF-IDF value. 
	 */
	public HashMap<String, Double> calculateTfidf(DataBase db, FeedMessage msg) {
		// TODO Auto-generated method stub
		TreeSet<info> set = new TreeSet<>();
		Map<String, Integer> wordCountMap = db.getFeedMessageMap().get(msg);
		int total_doc = db.getDbSize();
		int docSize = 0;
		for (String s : wordCountMap.keySet()) {
			docSize += wordCountMap.get(s);
		}
		for (String s : wordCountMap.keySet()) {
			if (s == null)
				continue;
			double tf = (double) wordCountMap.get(s) / docSize;
			double idf = Math.log((double) total_doc / db.getAllTermMap().get(s));
			Double score = tf * idf;
			info temp = new info(s, score);
			set.add(temp);
		}
		HashMap<String, Double> ret = new HashMap<>();
		for (int i = 0; i < set.size(); i++) {
			info temp = set.pollFirst();
			if (temp == null)
				continue;
			ret.put(temp.keyword, temp.score);
		}
		return ret;
	}
}
