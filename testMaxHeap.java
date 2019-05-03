import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testMaxHeap {
    @Test
    public void testHeapSize() {
        int size = 10;
        String test = "Philly";
        MaxHeap heap = new MaxHeap(size, test);
        assertEquals(0, heap.heapSize());
    }

    @Test
    public void testIsLeaf() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       
       
//        FeedMessage fm4 = new FeedMessage();
//        FeedMessage fm5 = new FeedMessage();
//        feed.getMessages().add(fm4);
//        feed.getMessages().add(fm5);
        db.store(feed);
        heap.insert(fm1);
        heap.insert(fm2);
        heap.insert(fm3);
//        heap.insert(fm4);
//        heap.insert(fm5);
        assertTrue(heap.isLeaf(2));
    }

    @Test
    public void testLeftChild() {
    	 DataBase db = new DataBase();
         try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int size = 10;
        String test = "philly";
        MaxHeap heap = new MaxHeap(size, test);
        Feed feed = new Feed("title", "link", "description", "language",
                "copyright", "pubdate");
        FeedMessage fm1 = new FeedMessage();
        FeedMessage fm2 = new FeedMessage();
        FeedMessage fm3 = new FeedMessage();
        String title = "tittle1";
        String description = "description1";
        String link = "link1";
        String author = "author1";
        String guid = "guid1";
        fm1.setAuthor(author);
        fm1.setDescription(description);
        fm1.setGuid(guid);
        fm1.setLink(link);
        fm1.setTitle(title);
        fm1.setNewsText("contains word1 word2 word3 unique Philly");
        title = "tittle2";
        description = "description2";
        link = "link2";
        author = "author2";
        guid = "guid2";
        fm2.setAuthor(author);
        fm2.setDescription(description);
        fm2.setGuid(guid);
        fm2.setLink(link);
        fm2.setTitle(title);
        fm2.setNewsText("contains word1 word2 unique Philly");
        title = "tittle3";
        description = "description3";
        link = "link3";
        author = "author3";
        guid = "guid3";
        fm3.setAuthor(author);
        fm3.setDescription(description);
        fm3.setGuid(guid);
        fm3.setLink(link);
        fm3.setNewsText("contains word1 word2 word4 unique Philly");
        fm3.setTitle(title);
        
        feed.getMessages().add(fm1);
        feed.getMessages().add(fm2);
        feed.getMessages().add(fm3);
        db.store(feed);
        heap.insert(fm1);
        heap.insert(fm2);
        heap.insert(fm3);
        
        
        assertEquals(-1, heap.leftChild(5));
        assertEquals(1, heap.leftChild(0));
    }

    @Test
    public void testRightChild() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        assertEquals(-1, heap.rightChild(5));
        assertEquals(2, heap.rightChild(0));
    }

    @Test
    public void testParent() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        assertEquals(-1, heap.parent(0));
        assertEquals(0, heap.parent(1));
    }

    @Test
    public void testToList() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        List<FeedMessage> fmlist = new ArrayList();
        fmlist.add(fm1);
        fmlist.add(fm2);
        fmlist.add(fm3);
        List<FeedMessage> arr = heap.toList();
        assertEquals(fmlist.size(), arr.size());
    }

    @Test
    public void testSwap() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        FeedMessage[] arr = new FeedMessage[3];
        arr[0] = fm1;
        arr[1] = fm2;
        arr[2] = fm3;
        heap.swap(arr, 0, 1);
    }

    @Test
    public void testSiftDown() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        heap.buildHeap();
        heap.siftDown(-1);
    }

    @Test
    public void testRemoveMax() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        FeedMessage testfm = heap.removeMax();
        heap.insert(testfm);
        assertEquals(testfm, heap.removeMax());
        heap.removeMax();
        heap.removeMax();
        heap.removeMax();
    }

    @Test
    public void testRemove() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        assertNull(heap.remove(-1));
        FeedMessage testfm = heap.remove(0);
        heap.insert(testfm);
        assertEquals(testfm, heap.remove(0));
    }

    @Test
    public void testModifyandUpdate() {
    	DataBase db = new DataBase();
        try {
			db.initStopList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       int size = 10;
       String test = "philly";
       MaxHeap heap = new MaxHeap(size, test);
       Feed feed = new Feed("title", "link", "description", "language",
               "copyright", "pubdate");
       FeedMessage fm1 = new FeedMessage();
       FeedMessage fm2 = new FeedMessage();
       FeedMessage fm3 = new FeedMessage();
       String title = "tittle1";
       String description = "description1";
       String link = "link1";
       String author = "author1";
       String guid = "guid1";
       fm1.setAuthor(author);
       fm1.setDescription(description);
       fm1.setGuid(guid);
       fm1.setLink(link);
       fm1.setTitle(title);
       fm1.setNewsText("contains word1 word2 word3 unique Philly");
       title = "tittle2";
       description = "description2";
       link = "link2";
       author = "author2";
       guid = "guid2";
       fm2.setAuthor(author);
       fm2.setDescription(description);
       fm2.setGuid(guid);
       fm2.setLink(link);
       fm2.setTitle(title);
       fm2.setNewsText("contains word1 word2 unique Philly");
       title = "tittle3";
       description = "description3";
       link = "link3";
       author = "author3";
       guid = "guid3";
       fm3.setAuthor(author);
       fm3.setDescription(description);
       fm3.setGuid(guid);
       fm3.setLink(link);
       fm3.setNewsText("contains word1 word2 word4 unique Philly");
       fm3.setTitle(title);
       
       feed.getMessages().add(fm1);
       feed.getMessages().add(fm2);
       feed.getMessages().add(fm3);
       db.store(feed);
       heap.insert(fm1);
       heap.insert(fm2);
       heap.insert(fm3);
        FeedMessage fm = new FeedMessage();
        title = "tittle3";
        description = "description3";
        link = "link3";
        author = "author3";
        guid = "guid3";
        fm.setAuthor(author);
        fm.setDescription(description);
        fm.setGuid(guid);
        fm.setLink(link);
        fm.setNewsText("contains word1 xxx word2 word4 unique Philly");
        fm.setTitle(title);
        feed.getMessages().add(fm);
        db.store(feed);
        heap.modify(1, fm);
    }
}