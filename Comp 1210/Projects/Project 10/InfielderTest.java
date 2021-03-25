import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class InfielderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test of getters. **/
   @Test public void gettersTest() {
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B",
         1.25, .275, .850);
      
      
      Assert.assertEquals("getInfielderFieldingTest", .850,
             p2.getInfielderFieldingAvg(), .001);
   }
   
   /** A test of setters. */
   @Test public void settersTest() { 
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B",
         1.25, .275, .850);
      p2.setInfielderFieldingAvg(.525);
   
      Assert.assertEquals(.525, p2.getInfielderFieldingAvg(), .001);  
   }
   
   /** A test of ratings. */ 
   @Test public void ratings() { 
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B",
         1.25, .275, .850);
      
      Assert.assertEquals("ratings Test", 2.9218750000000004, 
         p2.rating(), .001);
   }
}
