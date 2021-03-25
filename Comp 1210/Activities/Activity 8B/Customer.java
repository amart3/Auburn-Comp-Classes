/** 
*Activity 8B. 
*@author Lawrence Martin.
*@version 3/24/19.
*/

public class Customer implements Comparable<Customer> {

//Instance Variables 
   private String name;
   private String location;
   private double balance;

//Constructor
 
/** 
*@param nameIn takes name. 
*/
   public Customer(String nameIn) { 
      name = nameIn; 
      location = "";
      balance = 0; 
   }
  // Methods
  
  /**
  *@return name.
  */
   public String getName() {
      return name; 
   }
  
  /** 
  *@param locationIn takes location. 
  */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
   *@param amount takes balance in.
   */
   public void changeBalance(double amount) {
      balance = balance + amount; 
   }
   
   /**
   *@return location.
   */
   public String getLocation() {
      return location; 
   }
   
   /**
   *@return balance.
   */
   public double getBalance() {
      return balance; 
   }
   
   /** 
   *@param city takes city in. 
   *@param state takes state in. 
   */
   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }
   
   /**
   *@return toString. 
   */ 
   public String toString() { 
      return name + "\n"
         + location + "\n" 
         + "$" + balance; 
   }
   
   /**
   *@param obj takes in. 
   *@return if equal,  less, or greater than.
   */
   public int compareTo(Customer obj) { 
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) { 
         return 0; 
      }
      else if (this.balance < obj.getBalance()) { 
         return -1;
      }
      else { 
         return 1;
      }
   }
}