import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testDataBase {
    @Test
    public testFetch() {
        DataBase db = new DataBase();
        db.fetch("Philly");
    }

    @Test
    public testStore() {
        DataBase db = new DataBase();
        assertEquals(-1, db.store(null));
        Feed feed = new Feed("a", "b", "c", "d", "e", "1");
        assertEquals(1, db.store(feed));
    }
}