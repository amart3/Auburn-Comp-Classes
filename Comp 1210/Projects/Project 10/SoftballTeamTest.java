import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
*Project 10. 
*@author Lawrence Martin.
*@version 4/8/19.
*/

public class SoftballTeamTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test for getTeamName. 
     * @throws IOException in case there is no file
     */
   @Test public void getTeamNameTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
   	  	
      Assert.assertEquals("getTeamName Test", 	  	
          "Auburn Stars", sbt.getTeamName());	  	
   }
   
   /** A test for setTeamName(). 
     * @throws IOException in case there is no file
     */
   @Test public void setTeamNameTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.setTeamName("Stars");
      Assert.assertEquals("setTeamName Test", 	  	
          "Stars", sbt.getTeamName());  		  	
   }
   
   /** A test for get/setRoster(). 
     * @throws IOException in case there is no file
     */
   @Test public void getRosterTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
      SoftballPlayer[] s = new SoftballPlayer[24];
      Outfielder p1 = new Outfielder("32", "Jackie Robinson", "RF", 1.0,
                           .375, .950);
      s[0] = p1;
      sbt.setRoster(s); 
            		  	
      Assert.assertEquals("getRoster Test", 	  	
           sbt.getRoster()[0], p1); 
   }

   /** A test for get/setPlayerCount(). 
     * @throws IOException in case there is no file
     */
   @Test public void getPlayerCountTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam();        		  	
      sbt.setPlayerCount(5);
      Assert.assertEquals("getPlayerCount Test", 	  	
           sbt.getPlayerCount(), 5, 0); 
   }      
   
   /** A test for get/setExcludedRecords().
   * @throws IOException in case there is no file
   */ 
   @Test public void getExcludedRecordsTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
   	  	
      Assert.assertTrue("getExcludedRecords Test", 	  	
          sbt.getExcludedRecords()[0].contains("L")); 
      String[] help = {"Auburn", "Tigers"};
      sbt.setExcludedRecords(help);     
      Assert.assertEquals("getExcludedRecords Test", 	  	
          help[1], sbt.getExcludedRecords()[1]);            	  	
   }
   
   /** A test for get/setIgnoredCount(). 
   *@throws IOException in case there is no file
   */ 
   @Test public void getIgnoredCountTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
   	  	
      Assert.assertEquals("getIgnoredCount Test", 	  	
          sbt.getIgnoredCount(), 0);    
     
      sbt.setIgnoredCount(12);
        	
      Assert.assertEquals("getIgnoredCount Test", 	  	
          sbt.getIgnoredCount(), 12);              	           	  	
   }
    
   /** A test for get/setExcludedCount(). 
   *@throws IOException in case there is no file
   */ 
   @Test public void getExcludedCountTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
   	  	
      Assert.assertEquals("getExcludedCount Test", 	  	
          sbt.getExcludedCount(), 1);
          
      sbt.setExcludedCount(20);
          
      Assert.assertEquals("getExcludedCount Test", 	  	
          sbt.getExcludedCount(), 20);              	  	
   }
   
   /** A test for getTeamCount(). 
   *@throws IOException if no file.
   */ 
   @Test public void getTeamCountTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
      sbt.resetTeamCount(); 	
      Assert.assertEquals("getTeamCount Test", 	  	
          sbt.getTeamCount(), 0);              	  	
   }
   
   /** A test for generateReports(). 
   *@throws IOException if no file
   */ 
   @Test public void generateReportsTest() throws IOException {	
      SoftballTeam sbt = new SoftballTeam(); 
      sbt.readPlayerFile("softball_player_data1.csv");
   	  	
      Assert.assertEquals("generateReport Test", true,  	  	
          sbt.generateReport().toString().contains("T"));
                 	  	  	
      Assert.assertEquals("generateReportByNumber Test", true, 	  	
          sbt.generateReportByNumber().toString().contains("L"));
         	  	
      Assert.assertEquals("generateReportByName Test", true,  	  	
          sbt.generateReportByName().toString().contains("Team"));
                 	  	      	  	
      Assert.assertEquals("generateReportByRating Test", true,	  	
          sbt.generateReportByRating().toString().contains("T"));
                 	  	      	  	
      Assert.assertEquals(" generateExcludedRecordsReport Test", true, 
         sbt.generateExcludedRecordsReport().toString().contains("E"));
         
         
      sbt.setPlayerCount(30);
      sbt.readPlayerFile("softball_player_data1.csv");
      sbt.setExcludedCount(30);   
      sbt.readPlayerFile("softball_player_data1.csv");
      
      
   }
}
