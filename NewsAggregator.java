import java.util.ArrayList;
import java.util.List;

public class NewsAggregator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RSSReader reader = new RSSReader();
		List<FeedMessage> entries = reader.parseNewsText();
		for (FeedMessage entry: entries) {
			System.out.println(entry.getNewsText());
		}

	}

}
