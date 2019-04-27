
/**
 * Represents a single messages in a RSS feed
 * A RSS feed may contain multiple feed messages
 * @author Shiqing
 *
 */
public class FeedMessage {
	
	String title;
    String description;
    String link;
    String author;
    String guid;
    public int compareTo(FeedMessage fm, String keyWord){
        
        return 0;
    }
    /**
     * get the title of this FeedMessage
     * @return this FeedMessage's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * change the title of this FeedMessage
     * @param title this FeedMessage's new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get the description of this FeedMessage
     * @return this FeedMessage's new description
     */
    public String getDescription() {
        return description;
    }

    /**
     * change the description of this FeedMessage
     * @param description this FeedMessage's new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the link of this FeedMessage
     * @return this FeedMessage's link
     */
    public String getLink() {
        return link;
    }

    /**
     * change the link of this FeedMessage
     * @param link this FeedMessage's new link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * get the author of this FeedMessage
     * @return this FeedMessage's author
     */
    public String getAuthor() {
        return author;
    }

    
    /**
     * change the author of this FeedMessage
     * @param author this FeedMessage's new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get the link of this FeedMessage
     * @return this FeedMessage's link
     */
    public String getGuid() {
        return guid;
    }

    /**
     * change the link of this FeedMessage
     * @param guid this FeedMessage's new link
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * set the print format of this FeedMessage
     */
    @Override
    public String toString() {
        return "FeedMessage [title=" + title + ", description=" + description
                + ", link=" + link + ", author=" + author + ", guid=" + guid
                + "]";
    }

}
