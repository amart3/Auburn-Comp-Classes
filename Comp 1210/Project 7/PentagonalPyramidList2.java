//import java.util.ArrayList;
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
public class PentagonalPyramidList2 {
//Instance Variables
   private String list = ""; 
   private PentagonalPyramid[] pList;
   private int pLength;
     
   //Constructor 
   /**
   *passes values to methods.
   *@param listIn for list.
   *@param pListIn for pentagonalList.
   *@param pLengthIn for pLength.
   */
   public PentagonalPyramidList2(String listIn, PentagonalPyramid[] pListIn,
                                       int pLengthIn) {
      list = listIn;
      pList = pListIn;
      pLength = pLengthIn; 
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
      int numberOfPentagonalPyramids = 0;
      if (pLength > numberOfPentagonalPyramids) {
         numberOfPentagonalPyramids = pLength; 
         return numberOfPentagonalPyramids;
      }
      else { 
         return numberOfPentagonalPyramids;
      }
   }
   /** 
   *@return double totalSurfaceArea.
   */
   public double totalSurfaceArea() { 
      double total = 0; 
      int index = 0; 
      while (index < pLength) { 
         total += pList[index].surfaceArea(); 
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
      while (index < pLength) { 
         total += pList[index].volume();
         index++; 
      }
      return total;
   }
   /**
   *@return double averageSurfaceArea.
   */
   public double averageSurfaceArea() { 
      double total = 0;
      int index = 0; 
      
      while (index < pLength) {
         total += (pList[index].surfaceArea()) / pLength;
         index++;
      } 
      return total;
      
   }
  
   /**
   *@return double averageVolume.
   */
   public double averageVolume() { 
      double total = 0; 
      int index = 0; 
      while (index < pLength) {
         total += (pList[index].volume()) / pLength;
         index++;
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
      while (index < pLength) { 
         result += "\n" + pList[index] + "\n";
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
   public PentagonalPyramid[] getList() {
      return pList;
   }
   /** 
   *Reads in Pentagonal pyramid from file.
   *@param fileName for file to read.
   *@return pList
   *@throws FileNotFoundException if the file cannot be opened.
   */
   public PentagonalPyramidList2 readFile(String fileName)
                                 throws FileNotFoundException {
   
      Scanner scanFile = new Scanner(new File(fileName)); 
      PentagonalPyramid[] myList = new PentagonalPyramid[20];
      String nameOfListReadIn = scanFile.nextLine();
      int numPyramids = 0;
    
      while (scanFile.hasNext()) { 
         String label = scanFile.nextLine();
         double baseEdge = Double.parseDouble(scanFile.nextLine());
         double height = Double.parseDouble(scanFile.nextLine());
         PentagonalPyramid p = new PentagonalPyramid(label, baseEdge, height);
         myList[numPyramids] = p;
         numPyramids++;
      }
      PentagonalPyramidList2 pL = new PentagonalPyramidList2(nameOfListReadIn,
                                                 myList, numPyramids);
      return pL;
   }
   /** 
   *Adds Pentagonal Pyramid object to the List. 
   *@param baseEdge for baseEdge.
   *@param height for height.
   *@param label for label. 
   */
   public void addPentagonalPyramid(String label, double baseEdge, 
                                                   double height) {
   
      PentagonalPyramid p = new PentagonalPyramid(label, baseEdge,
                                  height);
      pList[pLength] = p;
      pLength++;
      
   } 
   /**
   *@param label takes the label to find in the arraylist.
   *@return returns the object in the arraylist .
   */
   public PentagonalPyramid findPentagonalPyramid(String label) { 
      PentagonalPyramid result = null; 
      for (int i = 0; i < pLength; i++) { 
         if (pList[i].getLabel().equalsIgnoreCase(label)) {
            result = pList[i];
            break;
         }
      }
      return result; 
   }
   /** 
   *Deletes a PentagonalPyrmaid from the list.
   *@param label deletes label from array list. 
   *@return returns object deleted.
   */ 
   public PentagonalPyramid deletePentagonalPyramid(String label) { 
      int indexToDelete = 0; 
      PentagonalPyramid result = null;
      for (int i = 0; i < pLength; i++) { 
         if (pList[i].getLabel().equalsIgnoreCase(label)) { 
            result = pList[i]; 
            indexToDelete = i; 
            break; 
         }
      }
         
      if (result != null) { 
         for (int i = indexToDelete; i < pLength - 1; i++) { 
            pList[i] = pList[i + 1];
         } 
         pList[pLength - 1] = null; 
         pLength--;
      }
      return result;
   }
            
   /**
   *@param label takes input for label to find in array list.
   *@param baseEdge takes input for the baseEdge in the constructor.
   *@param height takes input for the height in the constructor. 
   *@return returns if edit works.
   */
   public boolean editPentagonalPyramid(String label, double baseEdge,
                                                 double height) { 
      boolean result = false; 
      for (PentagonalPyramid pentaList : pList) { 
         if (pentaList != null) { 
            if (pentaList.getLabel().equalsIgnoreCase(label)) { 
               pentaList.setBaseEdge(baseEdge); 
               pentaList.setHeight(height); 
               result = true; 
               break;
            }
         
         }
         
      }
      return result; 
   }
}

