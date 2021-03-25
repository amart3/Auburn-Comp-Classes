import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/** 
*Project 5.
*@author Lawrence Martin 
*@version 2/18/19
*/
public class PentagonalPyramidListApp {
/**
*Tells the amount of Pentagonal Pyramids there are.
*@param args Command line arguments - (not used).
*@throws FileNotFoundException 
*/
   public static void main(String[] args) throws FileNotFoundException 
   { 
      ArrayList<PentagonalPyramid> pentagonalList 
         = new ArrayList<PentagonalPyramid>();
         
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: "); 
      String fileName = scan.nextLine();
      
        
      Scanner scanFile = new Scanner(new File(fileName));
      String pyramidList = scanFile.nextLine();
        
      while (scanFile.hasNext()) {
      
         String label = scanFile.nextLine(); 
         double baseEdge = Double.parseDouble(scanFile.next()); 
         double height = Double.parseDouble(scanFile.next()); 
       
         PentagonalPyramid penta 
            = new PentagonalPyramid(label, baseEdge, height);
         pentagonalList.add(penta); 
      }
      scanFile.close(); 
      PentagonalPyramidList myPentagonalList
          = new PentagonalPyramidList(pyramidList, pentagonalList);
      System.out.println();
      System.out.println(myPentagonalList);
      System.out.println();
      System.out.println(myPentagonalList.summaryInfo()); 
   }
}
