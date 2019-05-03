import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testUser {
    
	@Test
    public void testGetUserID() {
        User user = new User(0);
        assertEquals(user.getUserID(), 0);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void testSearchNULL() {
        User user = new User(0);
        user.search(null, null);
    }
	
	
    @Test(expected = NullPointerException.class)
    public void testViewArticleNULL() {
    	
        User user = new User(0);
        user.viewArticle(null);
    }
    
//    @Test
//    public void testViewArticle() {
//    String s = "(Reuters) - The Mississippi River has reached record high levels in the area of Rock Island, Illinois, as melting heavy snowpack coupled with rain has caused widespread flooding, a national hydrologist said on Friday. Heavy rain in the central United States brought the river’s level to a new peak of 22.7 feet at Rock Island, just topping the 1993 record of 22.63 feet, according to hydrologist Justin Palmer at the North Central River Forecast Center in Chanhassen, Minnesota. “As far as Rock Island is concerned, the stars kind of aligned to where they got rain right on top of what was already cresting near the record,” Palmer said. Images on social media showed the downtown area of Davenport, Iowa underwater, directly across a narrow stretch of the Mississippi from Rock Island. One image showed people traveling by boat along a submerged road. Other parts of the Mississippi River were experiencing major flooding on Friday along the Iowa-Illinois border, but Palmer said they were not expected to reach the same historic levels. That could change if the rain in the forecast over the next several days pushes the crest. “It’s just not going to give the river the chance to recede over the next couple of days,” said Dan Petersen, a meteorologist at the National Weather Service’s Weather Prediction Center in College Park, Maryland. This week’s flooding has come early in the season, as the historic 1993 flooding occurred in June and July, Palmer said. The snowpack in the Midwest will continue melting through the summer, causing rivers to swell. “We’re still vulnerable for the rest of the season,” Palmer said. The U.S. Coast Guard closed the Mississippi near St. Louis to boat and barge traffic on Friday, because of high water levels and fast moving currents. The river is a key transportation artery for shipments of grain, agricultural chemicals, energy products and other commodities. Reporting by Gabriella Borter; Editing by Steve Orlofsky Our Standards:The Thomson Reuters Trust Principles.\r\n";
//    	User user = new User(0);
//    	user.viewArticle(msg)
//    }

    
    
    
}

