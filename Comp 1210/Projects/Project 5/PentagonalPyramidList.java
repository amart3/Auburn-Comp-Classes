import java.util.ArrayList;
import java.text.DecimalFormat;
/** 
*Project 5.
*@author Lawrence Martin 
*@version 2/18/19
*/
public class PentagonalPyramidList {
//Instance Variables
   private String list = ""; 
   private ArrayList<PentagonalPyramid> pList;
     
   //Constructor 
   /**
   *passes values to methods.
   *@param listIn for list.
   *@param pListIn for pentagonalList.
   */
   public PentagonalPyramidList(String listIn,
      ArrayList<PentagonalPyramid> pListIn) {
      list = listIn;
      pList = pListIn; 
   }
   //Methods 
   /**
   *@return list.
   */
   public String getName() {
      return list;
   }
   /**
   *@return numberOfPentagonalPyramids.
   */
   public int numberOfPentagonalPyramids() { 
      return pList.size();
   }
   /** 
   *@return double totalSurfaceArea.
   */
   public double totalSurfaceArea() { 
      double total = 0; 
      int index = 0; 
      while (index < pList.size()) { 
         total += pList.get(index).surfaceArea(); 
         index++;
      }
      return total; 
   }
   /**
   *@return double totalVolume.
   */
   public double totalVolume() { 
      double total = 0;
      int index = 0; 
      while (index < pList.size()) { 
         total += pList.get(index).volume();
         index++; 
      }
      return total;
   }
   /**
   *@return double averageSurfaceArea.
   */
   public double averageSurfaceArea() { 
      double total = 0;
      if (total < pList.size()) {
         return totalSurfaceArea() / numberOfPentagonalPyramids();
      
      }
      return total; 
   }
   /**
   *@return double averageVolume.
   */
   public double averageVolume() { 
      double total = 0; 
      if (total < pList.size()) { 
         return totalVolume() / numberOfPentagonalPyramids();
      }
      return total; 
   }
   /**
   *Method of printing results in a string.
   *@return result.
   */
   public String toString() {
      String result = list + "\n"; 
      int index = 0; 
      while (index < pList.size()) { 
         result += "\n" + pList.get(index) + "\n";
         index++;
      }
      return result;
   }
   /**
   *print summary.
   *@return result.
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = ""; 
      result += "----- Summary for " + getName() + " -----";
      result += "\nNumber of PentagonalPyramid: " 
         + numberOfPentagonalPyramids();
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea());
      result += "\nTotal Volume: " + df.format(totalVolume());
      result += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
      result += "\nAverage Volume: " + df.format(averageVolume());
      return result;
   }
}