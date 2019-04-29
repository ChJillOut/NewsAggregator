import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsAggregator {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		RSSReader reader = new RSSReader();
		Feed feed = reader.parseNewsText();
		System.out.println("Result1");
		List<FeedMessage> messagesList = feed.getMessages();
		for (FeedMessage entry: messagesList) {
			System.out.println(entry.getNewsText());
		}
		DataBase db = new DataBase();
		System.out.println("Result2");
		
		// new feed with smaller capacity
		Feed newFeed = new Feed(feed, 20);
		db.initStopList();
		System.out.println("init stop list");
		TfidfFilter filter = new TfidfFilter();
		System.out.println("Started store");
		db.store(newFeed);
		FeedMessage testMessage = messagesList.get(1);
		Map<String, Double> tfidf_test = filter.calculateTfidf(db, testMessage);
		int count = 0;
		System.out.println("hmm");
		System.out.println("Result3");
//		for (String s: tfidf_test.keySet()) {
//			count++;
//			System.out.println("Term " + s + " " + count + " " + tfidf_test.get(s));
//		}
		User user = new User(0);
		
		//testing user
		System.out.println(db.getDb().keySet().toString());
		for (String s : db.getWordMap().keySet()) {
			System.out.println(s + ": "+ db.getWordMap().get(s).size());
		}
//		List<FeedMessage> list = user.search("assassination", db);
//		for (FeedMessage f : list) {
//			System.out.println(f.link);
//		}
//		System.out.println();
	}

}
