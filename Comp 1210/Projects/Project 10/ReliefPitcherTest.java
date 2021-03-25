import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class ReliefPitcherTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test of getters. **/
   @Test public void gettersTest() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
      
      Assert.assertEquals("getSaves Test", 17,  p4.getSaves(), .001);
   
   }
   
   /** A test of setters. */ 
   @Test public void setterTest() { 
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
   
      p4.setSaves(17); 
      Assert.assertEquals(17, p4.getSaves()); 
   }
   
   /** A test of ratings. */ 
   @Test public void ratingsTest() { 
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
      
      Assert.assertEquals("ratings Test", 2.4742268041237114, 
            p4.rating(), .001);    
   }
   
   /** A test of stats. */ 
   @Test public void statsTest() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
         
      Assert.assertEquals("stats Test", true, p4.stats().contains(""));
   }
}