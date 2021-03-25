import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** 
*Project8A.
*@author Lawrence Martin.
*@version 3/20/19
*/

public class PentagonalPyramidTest {

  /** Set up Method. */
   @Before public void setUp() {
   }
   
   /** A test of getters. */
   @Test public void gettersTest() { 
   
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
   
      Assert.assertEquals("getLabel test",
                       "Ex 1", pentaP.getLabel());
                       
      Assert.assertEquals("getBaseEdge test", 
                       1, pentaP.getBaseEdge(), .000001);
   
      Assert.assertEquals("getHeight test", 
                       2, pentaP.getHeight(), .000001); 
                        
   }
   
   /** A test of setters. */
   @Test public void settersTest() { 
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
   
      Assert.assertEquals("Ex 1", pentaP.getLabel());
      Assert.assertFalse("", pentaP.setLabel(null));
      
      Assert.assertEquals(true, pentaP.setBaseEdge(37)); 
      Assert.assertEquals(false, pentaP.setBaseEdge(-37));
      
      Assert.assertEquals(true, pentaP.setHeight(37));
      Assert.assertEquals(false, pentaP.setHeight(-37));
   
   } 
   
   
   
   
   /** A test if surfaceArea() works. */ 
   @Test public void surfaceAreaTest() { 
   
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
   
      Assert.assertEquals("surfaceArea test",
                        7.008203, pentaP.surfaceArea(), .000001);
   }
   
   
   /** A test if volume() works. */ 
   @Test public void volumeTest() { 
   
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
   
      Assert.assertEquals("volume test", 
                       1.1469849, pentaP.volume(), .000001); 
   }
   
   /** A test if toString works. */
   @Test public void toStringTest() { 
   
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
   
      Assert.assertEquals("toString test", 
                        true, 
                        pentaP.toString().contains("PentagonalPyramid"));
      
   }
   
   /** A trest if getCount() works. */ 
   @Test public void getCountTest() {
   
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
   
      pentaP.resetCount(); 
      Assert.assertEquals("", 0, pentaP.getCount());
   } 
   
   /** A test for equals. */ 
   @Test public void equalsTest() { 
   
      PentagonalPyramid pentaP = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid p = new PentagonalPyramid("Ex 1", 1, 2);
   
      Assert.assertEquals("equals test", 
                     true, pentaP.equals(p));
   
      p = new PentagonalPyramid("Ex 3", 1, 2);
      Assert.assertEquals("equals false test",
                        false, pentaP.equals(p));
                        
      p = new PentagonalPyramid("Ex 1", 3, 2);
      Assert.assertEquals("equals false test",
                        false, pentaP.equals(p));
                        
      p = new PentagonalPyramid("Ex 1", 1, 3);
      Assert.assertEquals("equals false test",
                        false, pentaP.equals(p));
   
      Assert.assertEquals("equals false test",
                        false, pentaP.equals("obj"));
   
   // test hashCode
      Assert.assertEquals("equals false test",
                        0, pentaP.hashCode());
   }
}