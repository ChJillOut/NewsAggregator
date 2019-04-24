import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testFeed {
    @Test
    public void testGetMessage() {
        Feed feed = new Feed("a", "b", "c", "d", "e", "1");
        List<FeedMessage> entries = new ArrayList<FeedMessage>();
        assertEquals(entries, feed.getMessages());
        assertEquals("a", feed.getTitle());
        assertEquals("b", feed.getLink());
        assertEquals("c", feed.getDescription());
        assertEquals("d", feed.getLanguage());
        assertEquals("e", feed.getCopyright());
        assertEquals("1", feed.getPubDate());
    }

    @Test
    public void testToString() {        
        Feed feed = new Feed("a", "b", "c", "d", "e", "1");
        assertEquals("Feed [copyright=e, description=c, language=d, link=b, pubDate=1, title=a");
    }
}