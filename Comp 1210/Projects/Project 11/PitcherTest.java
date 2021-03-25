import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class PitcherTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test of getters. **/
   @Test public void gettersTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 2.0,
             .125, 22, 4, 2.85);
   
      Assert.assertEquals("getWins Test", 22,
             p3.getWins(), .001);
      Assert.assertEquals("getLosses Test", 4,
            p3.getLosses(), .001); 
      Assert.assertEquals("getEra Test", 2.85, 
            p3.getEra(), .001);  
   }
   
   /** A test of setters. **/ 
   @Test public void settersTest() { 
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 2.0, 
            .125, 22, 4, 2.85);
            
      p3.setWins(22);
      Assert.assertEquals(22, p3.getWins());
      
      p3.setLosses(4);
      Assert.assertEquals(4, p3.getLosses());
      
      p3.setEra(2.85); 
      Assert.assertEquals(2.85, p3.getEra(), .001); 
   }
   
   /** A test of rating. */ 
   @Test public void ratingsTest() { 
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
            2.0, .125, 22, 4, 2.85);
   
      Assert.assertEquals("ratings Test", 3.74025974025974, p3.rating(), .001); 
   }
   
   /** A test of stats. */ 
   @Test public void statsTesting() { 
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP",
             2.0, .125, 22, 4, 2.85);
   
      Assert.assertEquals("stats Test", true, p3.stats().contains(""));
   
   }
}
