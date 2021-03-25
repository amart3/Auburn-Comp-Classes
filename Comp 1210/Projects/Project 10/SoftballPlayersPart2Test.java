import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class SoftballPlayersPart2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**
   *A test for mainMethod.
   *@throws IOException if no file.
   */
   @Test public void mainMethodTest() throws IOException {
      SoftballPlayersPart2 test =  new SoftballPlayersPart2(); 
      SoftballTeam.resetTeamCount();
      String[] test2 = {"softball_player_data1.csv"};
      SoftballPlayersPart2.main(test2); 
      Assert.assertEquals(1, SoftballTeam.getTeamCount());
   }
   
   /** 
   *A test for mainMethod2. 
   *@throws IOException if no file.
   */
   @Test public void mainMethod2Test() throws IOException { 
      SoftballTeam.resetTeamCount(); 
      String[] test3 = {}; 
      SoftballPlayersPart2.main(test3);
      Assert.assertEquals(1, SoftballTeam.getTeamCount()); 
   }
}
