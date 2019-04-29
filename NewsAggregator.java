import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsAggregator {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		RSSReader reader = new RSSReader();
		Feed feed = reader.parseNewsText();
//		System.out.println("Result1");
		List<FeedMessage> messagesList = feed.getMessages();
		for (FeedMessage entry: messagesList) {
			System.out.println(entry.getNewsText());
		}
		DataBase db = new DataBase();
//		System.out.println("Result2");
		
		// new feed with smaller capacity
		Feed newFeed = new Feed(feed, 10);
		db.initStopList();
//		System.out.println("init stop list");
		TfidfFilter filter = new TfidfFilter();
//		System.out.println("Started store");
		db.store(newFeed);
		FeedMessage testMessage = messagesList.get(1);
		Map<String, Double> tfidf_test = filter.calculateTfidf(db, testMessage);
		int count = 0;
//		for (int i = 0; i < feed.getMessages().size();i++) {
//			System.out.println(feed.getMessages().get(i).getMap());
//		}
//		
//		for (String s : db.getDb().keySet()) {
//			System.out.println(s+ ": "+db.getDb().get(s).heapSize());
//		}
		
		//Testing the aggregator's search method.
		User user = new User(0);
		String key = "global";
		System.out.println();
		System.out.println();
		List<FeedMessage> list = user.search(key, db);
		System.out.println("Searching for word: "+ key);
		for (FeedMessage f : list) {
			
			System.out.println("Link: "+ f.link);
			System.out.println("Title: "+ f.getTitle());
			System.out.println("Description:"+f.getDescription());
			System.out.println();
		}
		
		// testing the view article function
		FeedMessage read = list.get(3);
		System.out.println(user.viewArticle(read));
	}

}
