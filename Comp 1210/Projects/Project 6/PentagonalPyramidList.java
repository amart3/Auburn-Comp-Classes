import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/** 
*Project 6.
*@author Lawrence Martin 
*@version 2/18/19
*
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
   //__________________________________________\\
                 //New Methods\\
   //__________________________________________\\
   
   /** 
   *Get ArrayList objects.
   *@return myList 
   */
   public ArrayList<PentagonalPyramid> getList() {
      return pList;
   }
   /** 
   *Reads in Pentagonal pyramid from file.
   *@param fileNameIn for fileName to read.
   *@return pList
   *@throws FileNotFoundException if the file cannot be opened.
   */
   public PentagonalPyramidList readFile(String fileNameIn)
                                 throws FileNotFoundException {
   
      Scanner scanFile = new Scanner(new File(fileNameIn)); 
      ArrayList<PentagonalPyramid> myList = new ArrayList<PentagonalPyramid>(); 
      String label = ""; 
      double baseEdge = 0, height = 0; 
                                     
      list = scanFile.nextLine();
    
      while (scanFile.hasNext()) { 
         label = scanFile.nextLine();
         baseEdge = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         PentagonalPyramid p = new PentagonalPyramid(label, baseEdge, height);
         myList.add(p);
      }
      PentagonalPyramidList pL = new PentagonalPyramidList(list, myList);
      return pL;
   }
   /** 
   *Adds Pentagonal Pyramid object to the List. 
   *@param baseEdgeIn length of baseEdge.
   *@param heightIn length of height.
   *@param labelIn length of the label. 
   */
   public void addPentagonalPyramid(String labelIn, double baseEdgeIn, 
                                                   double heightIn) {
   
      PentagonalPyramid p = new PentagonalPyramid(labelIn, baseEdgeIn,
                                  heightIn);
      
      pList.add(p); 
   } 
   /**
   *@param labelIn takes the label to find in the arraylist.
      *@return returns the object in the arraylist .
   */
   public PentagonalPyramid findPentagonalPyramid(String labelIn) { 
      for (PentagonalPyramid p : pList) {
         if (p.getLabel().equalsIgnoreCase(labelIn)) { 
            return p;
         }
      }
      return null; 
   }
   /** 
   *Deletes a PentagonalPyrmaid from the list.
   *@param labelIn deletes label from array list. 
   *@return returns object deleted.
   */ 
   public PentagonalPyramid deletePentagonalPyramid(String labelIn) { 
      int index = pList.indexOf(findPentagonalPyramid(labelIn));
   
      if (index >= 0) {
         return pList.remove(index);
      }
      else { 
         return null;
      }
   }
   /**
   *@param labelIn takes input for label to find in array list.
   *@param baseEdgeIn takes input for the baseEdge in the constructor.
   *@param heightIn takes input for the height in the constructor. 
   *@return returns if edit works.
   */
   public boolean editPentagonalPyramid(String labelIn, double baseEdgeIn,
                                                 double heightIn) { 
      boolean result = false; 
      PentagonalPyramid p = findPentagonalPyramid(labelIn);
      if (p.getLabel().equalsIgnoreCase(labelIn)) { 
         p.setBaseEdge(baseEdgeIn);
         p.setHeight(heightIn);
         result = true; 
      }
      return result;
   }
}
