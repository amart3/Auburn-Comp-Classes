/** 
*Activity 9.
*@author Lawrence Martin.
*@version 3/30/19.
*/

public class ElectronicsItem extends InventoryItem {

//Instance Variables

   protected double weight;
   /**
   *
   */
   public static final double SHIPPING_COST = 1.5;

//Constructor 
/**
*@param weightIn for weight.
*@param nameIn for name.
*@param priceIn for price.
*/
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn; 
   }
   
   /** 
   *@return super.calculateCost() + (SHIPPING_COST * weight).
   */
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}
