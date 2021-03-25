/** 
*Activity 9.
*@author Lawrence Martin.
*@version 3/30/19
*/

public class InventoryItem { 

//Instance Variables 
   protected String name;
   protected double price;
   private static double taxRate = 0;

//Constructor 

/**
*@param nameIn for name.
*@param priceIn for price. 
*/
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }

//Methods 
/**
*@return name.
*/
   public String getName() {
      return name; 
   }
  
  /**
  *@return price * (1 + taxRate).
  */
   public double calculateCost() {
      return price * (1 + taxRate);
   }
   
   /** 
   *@param taxRateIn for taxRate.
   */
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn; 
   }
   
   /**
   *@return name + ": $" + calculateCost().
   */
   public String toString() {
      return name + ": $" + calculateCost(); 
   }


}