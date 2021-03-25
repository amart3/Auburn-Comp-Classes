import java.util.Scanner; 
/** 
*Project2.
*@author Lawrence Martin
*@version 1/23/19
*/

public class ImperialDistance
{
/**
*Converts the measurements. 
*values used must be non negatives.
*@param args Command line arguments – not used.
*/
   public static void main(String[] args) 
   {
      Scanner userInput = new Scanner(System.in);  
      int name = 0;
      int miles = 63360;
      int yards = 36;
      int feet = 12;
      int mi, yds, ft, in;
         
      System.out.print("Enter the raw distance measurement in inches: ");
      name = userInput.nextInt();
      
      if (name < 0) { //Do not give measurement. 
         System.out.println("Measurement must be non-negative!");
      }
      else { //Give measurements for distance.
      //prompt user for inches value.
         in = name;
         System.out.println();
      
      //Conversions
         System.out.println("Measurement by combined miles, "
            + "yards, feet, inches: ");
      
      
      //converting distances 
         mi = name / miles; 
         name %= miles; 
         yds = name / yards; 
         name %= yards; 
         ft = name / feet; 
         name %= feet;
      //Last Distance Conversion 
         System.out.println("\tmiles: " + mi);
         System.out.println("\tyards: " + yds); 
         System.out.println("\tfeet: " + ft); 
         System.out.println("\tinches: " + name); 
         System.out.println("\n" + in + " in = " + mi + " mi, "
            + yds + " yd, " 
            + ft + " ft, " 
            + name + " in");
      }
   }
}

