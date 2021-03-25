import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Project 10. 
*@author Lawrence Martin.
*@version 4/8/19.
*/

public class RatingComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Tests for RatingComparatorTest. */
   @Test public void ratingComparatorTest() {
   
      Outfielder p1 = new Outfielder("32", "Jackie Robinson", "RF", 1.0,
                           .895, 1.33);
      Outfielder p2 = new Outfielder("32", "Jackie Robinson", "RF", 2.0,
                           .895, 1.33);
      Outfielder p3 = new Outfielder("32", "Jackie Robinson", "RF", 1.0,
                           .895, 1.33); 
      RatingComparator rcomp = new RatingComparator();                       
      Assert.assertEquals(1, rcomp.compare(p1, p2), 0);
      Assert.assertEquals(-1, rcomp.compare(p2, p1), 0);
      Assert.assertEquals(0, rcomp.compare(p1, p3), 0);   
   }   
}
