 
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a single RSS feed 
 * @author Shiqing
 *
 */
public class Feed {
	final String title;
    final String link;
    final String description;
    final String language;
    final String copyright;
    final String pubDate;

    final List<FeedMessage> entries = new ArrayList<FeedMessage>();

    /**
     * creates a new Feed with the given fields 
     * @param title
     * @param link
     * @param description
     * @param language
     * @param copyright
     * @param pubDate
     */
    public Feed(String title, String link, String description, String language,
            String copyright, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    /**
     * get a list of contents acquired from this RSS feed
     * @return a list of FeedMessages objects
     */
    public List<FeedMessage> getMessages() {
        return entries;
    }

    /**
     * get the title of this RSS feed
     * @return this RSS feed's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * get the link of this RSS feed
     * @return this RSS feed's url
     */
    public String getLink() {
        return link;
    }

    /**
     * get the description of this RSS feed
     * @return this RSS feed's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * get the language of this RSS feed
     * @return this RSS feed's language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * get the copyright of this RSS feed
     * @return this RSS feed's copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * get the publication date of this RSS feed
     * @return this RSS feed's publication date
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * set the print format of this RSS feed
     */
    @Override
    public String toString() {
        return "Feed [copyright=" + copyright + ", description=" + description
                + ", language=" + language + ", link=" + link + ", pubDate="
                + pubDate + ", title=" + title + "]";
    }

}
