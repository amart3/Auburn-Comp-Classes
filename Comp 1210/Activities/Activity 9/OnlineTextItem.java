/** 
*Activity 9.
*@author Lawrence Martin.
*@version 3/30/19.
*/

public abstract class OnlineTextItem extends InventoryItem {

//Constructor
/**
*@param nameIn for name.
*@param priceIn for price/
*/ 
   public OnlineTextItem(String nameIn, double priceIn) { 
      super(nameIn, priceIn); 
   }
//Methods
/**
*@return price.
*/ 
   public double calculateCost() {
      return price;
   }
}