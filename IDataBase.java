import java.io.FileNotFoundException;
import java.util.List;
/**
 * The database interface that stores the news article and the terms in them.
 * @author Ji Xiayan
 *
 */
public interface IDataBase {
	/**
	 * Initialize a stop list to filter out the meaningless word.
	 * @throws FileNotFoundException
	 */
	public void initStopList() throws FileNotFoundException ;
	/**
	 * Update the database so that the db Map maps each keyword to a heap of new articles.
	 */
	public void updateDataBase();
	/**
	 * Fetch the news related to the keyword in the database
	 * @param keyWord the keyword of interest
	 * @return a list of new related to this topic
	 */
	public List<FeedMessage> fetch(String keyWord);
	/**
	 * Store all news from a new web site URL(e.g. CNN) into the database.
	 * @param feed all news from a particular news source.
	 * @return the number of news successfully stored
	 */
	public int store(Feed feed);
}
