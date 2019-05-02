import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class testRSSFeedParser {
	@Test
	public void testReadFeed() throws IOException {
		RSSFeedParser fp = new RSSFeedParser("http://feeds.reuters.com/Reuters/domesticNews");
		Feed feed = new Feed("Reuters News", "", "Reuters.com is your source for breaking news, business, financial and investing news, including personal finance and stocks.  Reuters is the leading global provider of news, financial information and technology solutions to the world's media, financial institutions, businesses and individuals.", "en-us",
	            "All rights reserved. Users may download and print extracts of content from this website for their own personal and non-commercial use only. Republication or redistribution of Reuters content, including by framing or similar means, is expressly prohibited without the prior written consent of Reuters. Reuters and the Reuters sphere logo are registered trademarks or trademarks of the Reuters group of companies around the world. © Reuters 2019", "");
		assertEquals(fp.readFeed().toString(), feed.toString());
		System.out.println(fp.readFeed().toString());
		System.out.println("///////////////////////////");
		System.out.println(feed.toString());
	}
}
