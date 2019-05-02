  import java.util.List;

public class User implements IUser {
	private int userID = 0;

	public User(int ID) {
		userID = ID;
	}

	/**
	 * Getter for user ID.
	 * 
	 * @return userID The user's ID.
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * With this method, user can search news with a keyWord, return list of related
	 * news.
	 * 
	 * @param keyWord the topic user is interested in
	 * @param db      the database storing all news available
	 * @return a list of overview of news
	 */
	@Override
	public List<FeedMessage> search(String keyWord, IDataBase db) {
		if (keyWord == null)
			throw new NullPointerException();
		return db.fetch(keyWord);
	}

	/**
	 * With this method, user can view the details of an article he or she is
	 * interested in.
	 * 
	 * @param msg the overview of a news obtained from search
	 * @return the full content
	 */
	@Override
	public String viewArticle(FeedMessage msg) {
		if (msg == null)
			throw new NullPointerException();
		return msg.getNewsText();
	}

}
