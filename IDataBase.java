import java.util.List;

public interface IDataBase {
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
