import java.util.Scanner;
/**
*Project2.
*@author Lawrence Martin
*@version 1/23/19
*/
public class Solver
{
/** 
*Inputs values for X. 
*Inputs Values for Y. 
*Inputs values for Y. 
*@param args Command line arguments – not used.
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double y = 0;
      double z = 0;
      double result = 0;
      //Tells the equation.
      System.out.println("result = (10x + 4.1)"
           + " (5y + 8.7) / z");
      //prompt user for x value 
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble(); 
      //prompt user for y value 
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      //prompt user for z value 
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble(); 
      //calculate and show the result
      if (z == 0) { //Equation is 0 is z=0 
         result = 0;
      }
      else { //Calculate the equation
         result = ((10 * x) + 4.1) * ((5 * y + 8.7) / z);
      } 
      System.out.print("result = " + result); 
   }
}