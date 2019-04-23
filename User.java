import java.util.List;

public class User implements IUser{
	private int userID = 0; 
	
	public User(int ID) {
		userID = ID;
	}
	@Override
	public List<FeedMessage> search(String keyWord, IDataBase db) {
		// TODO Auto-generated method stub
		if (keyWord == null) throw new NullPointerException();
		return null;
	}

	@Override
	public String viewArticle(FeedMessage msg) {
		// TODO Auto-generated method stub
		if (msg == null) throw new NullPointerException();
		return null;
	}

}
