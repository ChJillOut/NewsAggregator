import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TfidfFilter implements ITfidfFilter {
	Map<FeedMessage, PriorityQueue> map = new HashMap<>();
	class info {
		String keyword;
		double score;
	}

	@Override
	public HashMap<String, Double> calculateTfidf(DataBase db, FeedMessage msg) {
		// TODO Auto-generated method stub
		initStopList();
		PriorityQueue<info> pq = new pq<>((a, b) -> b.score - a.score);
		wordTfidf(pq, )
		Set<String> words = new HashSet<>(Arrays.asList(arr));
		return null;
	}

	
}
