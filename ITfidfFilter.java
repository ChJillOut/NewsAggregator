import java.util.HashMap;

public interface ITfidfFilter {
	/**
	 * With this method, we can calculate the TF-IDF value of a news, returning the 
	 * top 10 relatively frequent words and their corresponding TF-IDF value.
	 * @param db
	 * @param msg
	 * @return a hash map recording the 10 words with highest TF-IDF value and the corresponding TF-IDF value. 
	 */
	public HashMap<String, Double> calculateTfidf(DataBase db, FeedMessage msg) ;
}
