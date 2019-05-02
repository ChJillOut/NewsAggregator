import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author Shiqing
 *
 */
public class RSSReader {
	
	public Feed parseNewsText() {
		
	//	RSSFeedParser parser = new RSSFeedParser("http://feeds.reuters.com/reuters/businessNews");
		
     	RSSFeedParser parser = new RSSFeedParser("http://feeds.reuters.com/Reuters/domesticNews");
        Feed feed = parser.readFeed();
//        System.out.println(feed);
        for (int i = 0; i < feed.getMessages().size(); i++) {
        	String url = feed.getMessages().get(i).getGuid();
//        	System.out.println(url);
        	
			try {
				Document doc = Jsoup.connect(url).get();
				Elements divTag = doc.getElementsByClass("StandardArticleBody_body");
				String text = divTag.text();
				feed.getMessages().get(i).setNewsText(text);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        	
        }
        return feed;
        
    }
}
