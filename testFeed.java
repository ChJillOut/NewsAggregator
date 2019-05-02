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
        assertEquals("Feed [copyright=" + feed.getCopyright() + ", description=" + feed.getDescription()
                + ", language=" + feed.getLanguage() + ", link=" + feed.getLink() + ", pubDate="
                + feed.getPubDate() + ", title=" + feed.getTitle() + "]", feed.toString());
    }
    

    @Test
    public void testFirstFeedConstructor() throws FileNotFoundException {
        DataBase db = new DataBase();
        db.initStopList();
//        assertNull(db.fetch("Philly"));
        Feed feed = new Feed("title", "link", "description", "language",
                "copyright", "pubdate");
        FeedMessage fm1 = new FeedMessage();
        FeedMessage fm2 = new FeedMessage();
        fm1.setAuthor("author1");
        fm1.setDescription("description1");
        fm1.setGuid("guid1");
        fm1.setLink("link1");
        fm1.setNewsText("contains word1 word2 word3");
        fm2.setTitle("tittle2");
        fm2.setAuthor("author2");
        fm2.setDescription("description2");
        fm2.setGuid("guid2");
        fm2.setLink("link2");
        fm2.setNewsText("contains word1 word2");
        fm2.setTitle("tittle2");
        feed.getMessages().add(fm1);
        feed.getMessages().add(fm2);
        Feed feed1 = new Feed(feed,2);
        assertEquals(2, db.store(feed));
    }
}