import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testUser {
    
    @Test(expected = NullPointerException.class)
    public void testSearchNULL() {
        User user = new User();
        user.search(null);
    }
    
    @Test(expected = NullPointerException.class)
    public void testViewArticle() {
        User user = new User();
        user.viewArticle(null);
    }
}