import java.util.List;

public interface IUser {
	/**
	 * With this method, user can search news with a keyWord, return list of related news.
	 * @param keyWord the topic user is interested in
	 * @param db the database storing all news available
	 * @return a list of overview of news
	 */
	public List<FeedMessage> search(String keyWord, IDataBase db);
	/**
	 * With this method, user can view the details of an article he or she is interested in.
	 * @param msg the overview of a news obtained from search
	 * @return the full content
	 */
	public String viewArticle(FeedMessage msg);
	
}
