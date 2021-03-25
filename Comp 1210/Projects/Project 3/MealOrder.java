import java.util.Scanner; 
import java.text.DecimalFormat;
import java.util.Random; 
/**
*Project3.
*@author Lawrence Martin
*@version 1/29/19
*/
public class MealOrder
{
   static final double DISCOUNT = 0.15;
   static final double DISCOUNT_THRESHOLD = 100.0;
/**Finds the adult meal.
*@param args Command line arguments (not used).
*/ 
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in); 
      Random generator = new Random(); 
      double total = 0.0;
      int luckyNumber = 0;
      DecimalFormat cash = new DecimalFormat("$#,##0.00");
      DecimalFormat prize  = new DecimalFormat("00000");
   
      String order; 
   
   //Prompts uer for order code.
      System.out.print("Enter your order code: ");
      String orderCode = userInput.nextLine(); 
      System.out.println("");
      String trimorderCode = orderCode.trim();
       
   
      if (trimorderCode.length() < 12) { //If less than 12 then do not work.
         System.out.println("Invalid Order Code.");
         System.out.println("Order code must have at least 12 characters.");  
      }
      else { //Enter your name and 12 charcters. 
         int aMeal = Integer.parseInt(trimorderCode.substring(0, 2)); 
       
         double price = Double.parseDouble(trimorderCode.substring(2, 6));  
         
         int childMeals = Integer.parseInt(trimorderCode.substring(6, 8));
      
         double priceChildMeal 
            = Double.parseDouble(trimorderCode.substring(8, 12));
         String name = trimorderCode.substring(12); 
         
         System.out.println("Name: " + name);
         System.out.println("Adult meals: " + aMeal + " at " 
            + cash.format(price / 100));
         System.out.println("Child meals: " + childMeals + " at " 
               + cash.format(priceChildMeal / 100));
         total = (aMeal * price + childMeals * priceChildMeal) / 100;
         double discount = 0;
         if (total > DISCOUNT_THRESHOLD) {
            System.out.println("Subtotal: " + cash.format(total));
            discount = total * DISCOUNT;
            System.out.println("15% Discount: -" + cash.format(discount));
         }
         
         System.out.println("Total: " + cash.format(total - discount));
         luckyNumber = generator.nextInt(10000);
         System.out.println("Lucky Number: " + prize.format(luckyNumber)); 
         
      }
      
   }
}
