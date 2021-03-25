import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/
public class OutfielderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test of getters. **/
   @Test public void gettersTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      p1.setNumber("32");
      Assert.assertEquals("getNumber Test", "32", p1.getNumber());
      
      p1.setName("Pat Jones");
      Assert.assertEquals("getNameIn Test", "Pat Jones", p1.getName()); 
      p1.setPosition("RF");
      Assert.assertEquals("getPosition Test", "RF", p1.getPosition()); 
      
      p1.setSpecializationFactor(1.0);
      Assert.assertEquals("getSpecializationFactor Test", 1.0, 
            p1.getSpecializationFactor(), .001);
      
      p1.setBattingAvg(.375);     
      Assert.assertEquals("getBattingAvg Test", .375, p1.getBattingAvg(), .001);
      
      p1.setOutfielderFieldingAvg(.950);
      Assert.assertEquals("getOutfielderFieldingTest", .950,
             p1.getOutfielderFieldingAvg(), .001);
   }
   
   /** A test of Setters. **/
   @Test public void settersTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
   
      p1.setOutfielderFieldingAvg(.783);
   
      Assert.assertEquals(.783, p1.getOutfielderFieldingAvg(), .001);
   }
   
   /** A test of resetCount. */
   @Test public void resetCountTest() {
   
      Outfielder.resetCount();
      Assert.assertEquals("getCount Test", 0, Outfielder.getCount());
   }
   
   /** A test of toStrings. */
   @Test public void toStringTest() { 
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
   
      Assert.assertEquals("toString test", 
                        true, 
                        p1.toString().contains("Outfielder"));
   }
}
