import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase implements IDataBase{
	final int MAX_HEAP_NUM = 100;
	HashMap<String, MaxHeap> db;
	public DataBase() {
		db = new HashMap<>();
	}
	@Override
	public List<FeedMessage> fetch(String keyWord) {
		// TODO Auto-generated method stub
		if (!db.keySet().contains(keyWord)) return null;
		ArrayList<FeedMessage> res = new ArrayList<>();
		for (String e : db.keySet()){
			if (e.equals(keyWord)){
				// keyword found, return the maxHeap in the form of a list
				MaxHeap heap = db.get(e);
				res = heap.toList();
			}
		}
		return res;
	}

	@Override
	public int store(Feed feed) {
		// TODO Auto-generated method stub
		if (feed == null) return -1;
		List<FeedMessage> msgList = feed.getMessages();
		
		for(FeedMessage msg: msgList){
			HashMap<String, Double> map = msg.getMap();
			for(String s : map.keySet()){
				MaxHeap heap = null;
				if (db.keySet().contains(s)){
					heap = db.get(s);
					
				}else{
					FeedMessage[] h = {msg};
					heap = new MaxHeap( h, h.length,  MAX_HEAP_NUM, s);
				}
				heap.insert(msg);
				db.put(s, heap);
					
			}
			
		}
		
		return feed.getMessages().size();
	}

}
