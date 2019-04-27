import java.util.HashMap;
import java.util.List;

public class DataBase implements IDataBase{
	HashMap<String, MaxHeap> db;
	public DataBase() {
		db = new HashMap<>();
	}
	@Override
	public List<FeedMessage> fetch(String keyWord) {
		// TODO Auto-generated method stub
		if (!db.keySet().contains(keyWord)) return null;
		for (String e : db.keySet()){
			if (e.equals(keyWord)){
				// keyword found, return the maxHeap in the form of a list
				
			}
		}
		return null;
	}

	@Override
	public int store(Feed feed) {
		// TODO Auto-generated method stub
		if (feed == null) return -1;
		return feed.getEntries().size();
	}

}
