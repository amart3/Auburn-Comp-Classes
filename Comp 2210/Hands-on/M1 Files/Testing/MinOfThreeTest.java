import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** all numbers are different **/
   @Test public void min1Search1Test() {
      int actual = MinOfThree.min1(1,2,3);
      int expected = 1;
   
      assertEquals(expected, actual);
   }
   
   /**  a and b equal c less. */
   @Test public void min1Search2Test() {
      int actual = MinOfThree.min1(2,2,1);
      int expected = 1;
   
      assertEquals(expected, actual); 
   }
   
   /** a and b equal c greater */
   @Test public void min2Search3Test() { 
      int actual = MinOfThree.min2(1,1,2);
      int expected = 1;
   
      assertEquals(expected, actual); 
   }
   
    /** a and c equal b is less **/
   @Test public void min2Search4Test() {
      int actual = MinOfThree.min2(2,1,2);
      int expected = 1;
   
      assertEquals(expected, actual);
   }
   
   /** a and c are equal b is greater **/
   @Test public void min2Search5Test() {
      int actual = MinOfThree.min2(1,2,1);
      int expected = 1;
   
      assertEquals(expected, actual);
   }
   
/** b and c are equal a is greater **/
   @Test public void min2Search6Test() {
      int actual = MinOfThree.min2(2,1,1);
      int expected = 1;
   
      assertEquals(expected, actual);
   }
   
   /** b and c are equal a is less **/
   @Test public void min2Search7Test() {
      int actual = MinOfThree.min2(1,2,2);
      int expected = 1;
   
      assertEquals(expected, actual);
   }
}
