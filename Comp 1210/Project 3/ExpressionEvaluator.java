import java.util.Scanner;
import java.text.DecimalFormat; 
/** 
*Project3.
*@author Lawrence Martin 
*@version 1/29/19
*/ 
public class ExpressionEvaluator 
{
/** 
*Evaluates an expression. 
*@param args Command line arguments (not used).
*/
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in); 
      double value = 0.0; 
      double result = 0.0;
      int decimalL = 0;
      int decimalR = 0;
      String holder = ""; 
      int index = 0;
      String left = "";
      String right = "";
   
   //prompts user for number.
      System.out.print("Enter a value for x: ");
      value = userInput.nextDouble(); 
   
   //Evaluate the expression by user input. 
      result = Math.sqrt(Math.abs(1.2 * Math.pow(value, 3) 
      - (10 * value) + 1) + Math.pow(5 * Math.pow(value, 4) - (7 
      * Math.pow(value, 3)), 2)) / (Math.pow(value, 2) + 10);
   
   //find the decimal point
      holder = Double.toString(result);
      index = holder.indexOf(".");
   
   //Finds the how many places are to the left and right of decimal point. 
      left = holder.substring(0, index); 
      right = holder.substring(index + 1); 
      decimalL = left.length();
      decimalR = right.length(); 
    
   //decimal format.
      DecimalFormat df = new DecimalFormat("#,##0.0###");
   
   //Print everything
      System.out.println("Result: " + result);
      System.out.println("# of characters to left of decimal point: " 
              + decimalL);
      System.out.println("# of characters to right of decimal point: " 
               + decimalR);
      System.out.println("Formatted Result: " + df.format(result));
   }
  
}
