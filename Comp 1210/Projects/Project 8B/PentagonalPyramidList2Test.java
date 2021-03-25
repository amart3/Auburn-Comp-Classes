import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
 /** 
*Project 8B.
*@author Lawrence Martin 
*@version 3/25/19
*
*/

public class PentagonalPyramidList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests getName(). */
   @Test public void getNameTest() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
     
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
     
      Assert.assertEquals("getName", "ListName", pList.getName());
   }
   
   /** Tests numberOfPentagonalPyramids().  */ 
   @Test public void numberOfPetagonalPyramidsTest() { 
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
      
      Assert.assertEquals("numberOfPentagonalPyramids", 
                                 1, pList.numberOfPentagonalPyramids());
   }
      
   /** Test for totalSurfaceArea().Avg Volume/ Surface A., Total Surface A. */
   @Test public void totalSurfaceAreaTest() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
      
      Assert.assertEquals("totalSurfaceAreaTest", 7.008203044562695, 
                                  pList.totalSurfaceArea(), .001);
      Assert.assertEquals("averageSurfaceArea", 7.008203044562695, 
                                  pList.averageSurfaceArea(),  .001);
      
      Assert.assertEquals("totalVolume", 7.008203044562695, 
                                  pList.totalSurfaceArea(), .001);
      Assert.assertEquals("averageVolume", 7.008203044562695,
                                  pList.averageSurfaceArea(),  .001);
   }
   
   /** Tests for toString. */ 
   @Test public void toStringTest() { 
     
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
     
      Assert.assertTrue(pList.toString().contains(""));
   }
   
   /** Tests for SummaryInfo(). */
   @Test public void summaryInfoTest() { 
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList =
                               new PentagonalPyramidList2("ListName", p, 1);
      Assert.assertTrue(pList.summaryInfo().contains(""));
   }
   
  /** Tests for getList(). */ 
   @Test public void getListTest() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
      
      Assert.assertEquals("getList Test", "ListName", pList.getName()); 
   }
   
   /** 
   *Tests for readFile().
   *@throws IOException for reading a file. 
   */ 
   @Test public void readFileTest() throws IOException {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", null, 0); 
      
      pList = pList.readFile("PentagonalPyramid_data_1.txt");
      
      Assert.assertEquals("readFile Test", "PentagonalPyramid Test List",
                         pList.getName());
   }
   
   /** Test for addPentagonalPyramid(). */ 
   @Test public void addPentagonalPyramid() { 
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
   
      PentagonalPyramid pen = new PentagonalPyramid("new", 5, 5);
      pList.addPentagonalPyramid("new", 5, 5);
      PentagonalPyramid[] pA = pList.getList();
         
      Assert.assertEquals("addPentagonalPyramid Test",
                           pen, pA[1]);
   }
   
   /** Test for findPentgonalPyramid(). */
   @Test public void findPentagonalPyramidTest() { 
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5); 
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1);
   
      pList.findPentagonalPyramid("Ex 1"); 
      Assert.assertEquals(null, pList.findPentagonalPyramid("sample")); 
   }
   
   /** Test for deletePentagonalPyramid(). */ 
   @Test public void deletePentagonalPyramid() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 3); 
      
      PentagonalPyramid deleted = new PentagonalPyramid("Ex 1", 1, 2);
      Assert.assertEquals(pList.deletePentagonalPyramid("Ex 1"), deleted);
      Assert.assertEquals(
               pList.deletePentagonalPyramid("Not an Example"), null);
      
   }
   
   /** Test for editPentagonalPyramid(). */
   @Test public void editPentagonalPyramid() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 1); 
                              
      Assert.assertTrue(pList.editPentagonalPyramid("Ex 1", 1, 2));
      Assert.assertFalse(
                pList.editPentagonalPyramid(
                     "njkn", 5, 3));                      
                              
   }
   
   /** Test for findPentgonalPyramidWithShortestBaseEdge().True. */
   @Test public void findPentagonalPyramidWithShortestBaseEdgeTrue() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 3); 
      
      Assert.assertEquals("findPentagonalPyramidWithShortestBaseEdge",
                           p[0],
                           pList.findPentagonalPyramidWithShortestBaseEdge());
                           
   }
   
   /** Test for findPentgonalPyramidWithShortestBaseEdge(). False */
   @Test public void findPentagonalPyramidWithShortestBaseEdgeFalse() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 0); 
      
      Assert.assertEquals("ShortestBaseEdge Test fail",
                           null,
                           pList.findPentagonalPyramidWithShortestBaseEdge());
   }
   
   
   /** Test for findPentagonalPyramidWithLongestBaseEdge(). True. */
   @Test public void findPentagonalPyramidWithLongestBaseEdgeTrue() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 3); 
      
      Assert.assertEquals("findPentagonalPyramidWithLongestBaseEdge",
                           p[2],
                           pList.findPentagonalPyramidWithLongestBaseEdge());
   }
   
   /** Test for findPentagonalPyramidWithLongestBaseEdge(). False. */
   @Test public void findPentagonalPyramidWithLongestBaseEdgeFalse() {
     
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 0); 
      
      Assert.assertEquals("longestBaseEdge Test fail",
                           null,
                          pList.findPentagonalPyramidWithLongestBaseEdge());
   }
   
   /** Test for findPentagonalPyramidWithSmallestVolume(). True. */
   @Test public void findPentagonalPyramidWithSmallestVolumeTrue() { 
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 3); 
                              
      Assert.assertEquals("findPentagonalPyramidWithSmallestVolume",
                           p[0],
                           pList.findPentagonalPyramidWithSmallestVolume());
   }
   
   /** Test for findPentagonalPyramidWithSmallestVolume(). False. */
   @Test public void findPentagonalPyramidWithSmallestVolumeFalse() { 
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 0); 
      
      Assert.assertEquals("smallestVolume Test fail",
                           null,
                          pList.findPentagonalPyramidWithSmallestVolume());
   }
   
   /** Test for findPentagonalPyramidWithLargestVolume(). True. */
   @Test public void findPentagonalPyramidWithLargestVolumeTrue() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 3); 
                              
      Assert.assertEquals("findPentagonalPyramidWithLargestVolume",
                           p[2],
                           pList.findPentagonalPyramidWithLargestVolume());
   }
   
   /** Test for findPentagonalPyramidWithLargestVolume(). False. */
   @Test public void findPentagonalPyramidWithLargestVolumeFalse() {
   
      PentagonalPyramid[] p = new PentagonalPyramid[100];
      p[0] = new PentagonalPyramid("Ex 1", 1, 2);
      p[1] = new PentagonalPyramid("Ex 2", 3, 4);
      p[2] = new PentagonalPyramid("Ex 3", 4, 5);
      PentagonalPyramidList2 pList = 
                              new PentagonalPyramidList2("ListName", p, 0); 
      
      Assert.assertEquals("LargestVolume Test fail",
                           null,
                          pList.findPentagonalPyramidWithLargestVolume());
   }
}