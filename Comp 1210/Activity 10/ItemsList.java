/**
*Activity 10.
*@author Lawrence Martin.
*@version 4/7/19.
*/

public class ItemsList {

//Instance Variables 
   private InventoryItem[] inventory; 
   private int count;

//Constructor 
   /** 
   *array for Items.
   */
   public ItemsList() { 
      inventory = new InventoryItem[20];
      count = 0;
   }
   
   //Methods
   
   /**
   *@param itemIn for item.
   */
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   }
   
   /**
   *@param electronicsSurcharge for surcharge.
   *@return total.
   */
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            total += inventory[i].calculateCost();
         }
      }
      return total;
   }
   /**
   *@return output.
   */
   public String toString() {
      String output = "All inventory:\n\n";
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      }
      return output;
   }
}
