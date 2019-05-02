import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class NewsAggregator {
	DataBase db;
	
	public NewsAggregator() throws FileNotFoundException{
				System.out.println("Parsing in the news...");
				RSSReader reader = new RSSReader();
				Feed feed = reader.parseNewsText();
				List<FeedMessage> messagesList = feed.getMessages();

				db = new DataBase();
				// Construct a new feed with smaller capacity otherwise it may take too long to calculate.
				Feed newFeed = new Feed(feed, 10);
				db.initStopList();
				db.store(newFeed);

	}
	public static void main(String[] args) throws FileNotFoundException  {
		Random rand = new Random(System.currentTimeMillis());
		NewsAggregator na = new NewsAggregator();
		//Testing the aggregator's search method.
		User user = new User(0);
//		String key = (String) na.db.getDb().keySet().toArray()[rand.nextInt(na.db.getDb().keySet().size())];
		System.out.println();
		System.out.println();
		
		
		System.out.println("These are the keyword available for search in our database, choose one you are interested from the list:");
		System.out.println(na.db.getDb().keySet().toString());
		Scanner sc = new Scanner(System.in); 
		String key = null;
		do {
		   key = sc.nextLine(); 
		   if (!na.db.getDb().keySet().contains(key))
			   System.out.println("Invalid input, please choose one within the list.");
		}while(!na.db.getDb().keySet().contains(key));
		List<FeedMessage> list = user.search(key, na.db);
		System.out.println("Searching for word: "+ key+". "+list.size()+" result(s) matching your search.");
		for (int i = 0; i < list.size();i++) {
			System.out.println("Result "+(i+1)+" :");
			System.out.println("Link: "+ list.get(i).link);
			System.out.println("Title: "+ list.get(i).getTitle());
			System.out.println("Description:"+list.get(i).getDescription());
			System.out.println();
		}
		// Testing the view article function.
		System.out.println("Choose one you'd like to view by inputing the result number: ");
//		int r = rand.nextInt(list.size());
		int r = 0;
		do {
			   r = sc.nextInt(); 
			   if (r > list.size() || r < 0)
				   System.out.println("Invalid input, please choose a valid input number.");
			}while(r > list.size() || r < 0);
		r--;
		FeedMessage read = list.get(r);
		System.out.println("User want to view result "+(r+1)+".");
		System.out.println(user.viewArticle(read));
	}

}
