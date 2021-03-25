import java.util.Scanner; 
/**
*Project4. 
*@author Lawrence Martin
*@version 2/6/19
*/
public class PentagonalPyramidApp {
/** 
*Find SA and Volume of Pentagonal Pyramid. 
*@param args Command line arguments (not used).
*/
   public static void main(String[] args) {
      System.out.println("Enter label, base edge, and height " 
         + "for a pentagonal pyramid.");
      System.out.print("\tlabel: "); 
      Scanner userInput = new Scanner(System.in); 
      String labels = userInput.nextLine(); 
      System.out.print("\tbase edge: ");
      double edges = userInput.nextDouble(); 
      if (edges <= 0) { 
         System.out.print("Error: base edge must be greater than 0."); 
      }
      else {
         System.out.print("\theight: "); 
         double heights = userInput.nextDouble();
      
         if (heights <= 0) { 
            System.out.println("Error: height must be greater than 0.");
         }
         else {  
            PentagonalPyramid answer = 
               new PentagonalPyramid(labels, edges, heights); 
            System.out.print("\n" + answer.toString());
         
         }
      }
   }
}
