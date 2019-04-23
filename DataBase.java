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
		return null;
	}

	@Override
	public int store(Feed feed) {
		// TODO Auto-generated method stub
		if (feed == null) return -1;
		return feed.getEntries().size();
	}

}
