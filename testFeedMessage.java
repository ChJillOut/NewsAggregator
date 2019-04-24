import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testFeedMessage {
    @Test
    public void testFeedMessage() {
        FeedMessage message = new FeedMessage();
        String tittle = "tittle";
        String description = "description";
        String link = "link";
        String author = "author";
        String guid = "guid";
        message.setAuthor(author);
        message.setDescription(description);
        message.setGuid(guid);
        message.setLink(link);
        message.setTitle(title);
        assertEquals(author, message.getAuthor());
        assertEquals(description, message.getDescription());
        assertEquals(guid, message.getGuid());
        assertEquals(link, message.getGuid());
        assertEquals(tittle, message.getAuthor());
    }

    @Test
    public void testToString() {
        FeedMessage message = new FeedMessage();
        String tittle = "tittle";
        String description = "description";
        String link = "link";
        String author = "author";
        String guid = "guid";
        message.setAuthor(author);
        message.setDescription(description);
        message.setGuid(guid);
        message.setLink(link);
        message.setTitle(title);
        assertEquals("FeedMessage [title=" + title + ", description=" + description
        + ", link=" + link + ", author=" + author + ", guid=" + guid
        + "]", message.toString());
    }
}