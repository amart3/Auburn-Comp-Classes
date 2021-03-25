/**
*Activity 11. 
*@author Lawrence Martin. 
*@version 4/14/19. 
*/ 

public class Division { 

//Methods 
   /**
   *@param numerator for numerator.
   *@param denominator for denominator.
   *@return numerator / denominator.
   */
   public static int intDivide(int numerator, int denominator) {
      try {
         return numerator / denominator;
      }
      catch (ArithmeticException e) {
         return 0;
      }
   }
   
   /**
    * Divides numbers as decimals.
    * @param numerator for numerator.
    * @param denominator for denominator.
    * @return numerator / denominator.
    */
   public static double decimalDivide(int numerator, int denominator) {
      if (denominator == 0) {
         throw new IllegalArgumentException("The denominator "
              + "cannot be zero.");
      }
      else {
         return (double) numerator / (double) denominator;
      }
   }   }