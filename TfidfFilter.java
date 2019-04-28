import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class TfidfFilter implements ITfidfFilter {
	Set<String> stoppedList  = new HashSet<>();
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
		return null;
	}
	
	public void initStopList() {
		File input = new File("../stoppedlist");
		Scanner sc = new Scanner(input);
		try {
			while (sc.hasNextLine());
			String s = sc.nextLine().trim();
			stoppedList.add(s);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

	
}
