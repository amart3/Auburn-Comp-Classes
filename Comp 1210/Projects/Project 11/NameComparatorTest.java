import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Project 10. 
*@author Lawrence Martin.
*@version 4/8/19.
*/

public class NameComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Outfielder p1 = new Outfielder("32", "Jackie Robinson", "RF", 1.0,
                           .895, 1.33);
      Outfielder p2 = new Outfielder("32", "Babe Ruth", "RF", 1.0,
                           .895, 1.33);                     
      Outfielder p3 = new Outfielder("32", "Jackie Robinson", "RF", 1.0,
                           .895, 1.33);
      Outfielder p4 = new Outfielder("32", "Jackie Robinson", "RF", 1.0,
                           .895, 1.33);
      Outfielder p5 = new Outfielder("32", "Michael Smith", "RF", 1.0,
                           .895, 1.33);
      NameComparator ncomp = new NameComparator();
      Assert.assertEquals(-1, ncomp.compare(p1, p2), 0);
      Assert.assertEquals(0, ncomp.compare(p1, p3), 0);
      Assert.assertEquals(0, ncomp.compare(p1, p4), 0);
      Assert.assertEquals(-1, ncomp.compare(p1, p5), 0);                 
   }
}
