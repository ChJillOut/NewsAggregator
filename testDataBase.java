import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testDataBase {
    @Test
    public void testFetch() throws FileNotFoundException{
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
        fm1.setNewsText("contains word1 word2 word3 unique");
        fm2.setTitle("tittle2");
        fm2.setAuthor("author2");
        fm2.setDescription("description2");
        fm2.setGuid("guid2");
        fm2.setLink("link2");
        fm2.setNewsText("contains word1 word2 unique");
        fm2.setTitle("tittle2");
        feed.getMessages().add(fm1);
        feed.getMessages().add(fm2);
        db.store(feed);
        List<FeedMessage> test = new ArrayList<>();
        test.add(fm1);
        List<FeedMessage> test2 = db.fetch("unique");
        assertEquals(test.get(1), test2.get(1));
        
    }

    @Test
    public void testStore() throws FileNotFoundException {
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
        assertEquals(2, db.store(feed));
    }
}