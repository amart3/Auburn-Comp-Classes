import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
//import java.io.IOException;

/**
*Project 11.
*@author Lawrence Martin.
*@version 4/24/19
*/

public class SoftballPlayersPart3Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**
   *A test for mainMethod.
   */
   @Test public void mainMethodTest() {
      SoftballPlayersPart3 test =  new SoftballPlayersPart3(); 
      SoftballTeam.resetTeamCount();
      String[] test2 = {"softball_player_data3a.csv"};
      SoftballPlayersPart3.main(test2); 
      Assert.assertEquals(1, SoftballTeam.getTeamCount());
   }
   
   /** 
   *A test for mainMethod2. 

   */
   @Test public void mainMethod2Test() { 
      SoftballTeam.resetTeamCount(); 
      String[] test3 = {}; 
      SoftballPlayersPart3.main(test3);
      Assert.assertEquals(0, SoftballTeam.getTeamCount()); 
   }
}


