import java.awt.TextField;
import java.util.HashMap;

/**
 * Represents a single messages in a RSS feed A RSS feed may contain multiple
 * feed messages
 * 
 * @author Shiqing
 * @source https://www.vogella.com/tutorials/RSSFeed/article.html
 *
 */
public class FeedMessage{

	String title;
	String description;
	String link;
	String author;
	String guid;
	String newsText;
	TfidfFilter calculator = new TfidfFilter();
	HashMap<String, Double> map;
	
	
	/**
	 * Default constructor
	 */
	public FeedMessage(){
		title = null;
		description = null;
		link = null;
		author = null;
		guid = null;
		newsText = null;
		map = new HashMap<>();
	}
	
	/**
	 * get the TFIDF filter of this FeedMessage
	 * @return this FeedMessage's TFIDF filter
	 */
	public TfidfFilter getCalculator() {
		return calculator;
	}

	/**
	 * get the TFIDF score map of this FeedMessage
	 * @return this FeedMessage's TFIDF score map
	 */
	public HashMap<String, Double> getMap() {
		return map;
	}

	/**
	 * calculate TFIDF score of the news article in this FeedMessage
	 * @param db TFIDF database 
	 * @return a HashMap that maps each word to its score
	 */
	public HashMap<String, Double> calculateTFIDFScore(DataBase db) {
		map = calculator.calculateTfidf(db, this);
		return map;
	}


	/**
	 * compare the TFIDF score of a keyword in this FeedMessage with that of the same keyword in another FeedMessage
	 * 
	 * @param fm
	 * @param keyWord
	 * @return -1 if message is smaller than fm; 0 if they are of the same rank; 1 otherwise.
	 */
	public int compareTo(FeedMessage fm, String keyWord) {
		Double s1 = map.get(keyWord);
		Double s2 = fm.map.get(keyWord);
		if (s1 < s2)
			return -1;
		else if (s1 == s2)
			return 0;
		else 
			return 1;
	}

	/**
	 * get the title of this FeedMessage
	 * 
	 * @return this FeedMessage's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * change the title of this FeedMessage
	 * 
	 * @param title
	 *            this FeedMessage's new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get the description of this FeedMessage
	 * 
	 * @return this FeedMessage's new description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * change the description of this FeedMessage
	 * 
	 * @param description
	 *            this FeedMessage's new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the link of this FeedMessage
	 * 
	 * @return this FeedMessage's link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * change the link of this FeedMessage
	 * 
	 * @param link
	 *            this FeedMessage's new link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * get the author of this FeedMessage
	 * 
	 * @return this FeedMessage's author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * change the author of this FeedMessage
	 * 
	 * @param author
	 *            this FeedMessage's new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * get the link of this FeedMessage
	 * 
	 * @return this FeedMessage's link
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * change the link of this FeedMessage
	 * 
	 * @param guid
	 *            this FeedMessage's new link
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
    /**
     * get the news content of this FeedMessage
     * @return this FeedMessage's news content
     */
    public String getNewsText() {
		return newsText;
	}

    /**
     * change the news content of this FeedMessage
     * @param newsText this FeedMessage's news content
     */
	public void setNewsText(String newsText) {
		this.newsText = newsText;
	}

	/**
	 * set the print format of this FeedMessage
	 */
	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", description=" + description + ", link=" + link + ", author=" + author
				+ ", guid=" + guid + "]";
	}

	
	

}
