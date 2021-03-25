import java.util.ArrayList;
/** 
*Activity 6.
*@author Lawrence Martin
*@version 2/25/19
*/
public class Temperatures {
   private ArrayList<Integer> temperatures =
      new ArrayList<Integer>();

//Constructor 
/** 
*passes variables to temperatures variable. 
*@param temperaturesIn for temperatures.
*/
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }
   //Methods
   /**
   *@return low.
   */
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 1; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }
   
   /**
   *@return high.
   */
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
   
      return high;
   }
   /**
   *works for getLow temperature.
   *@param lowIn Command line arguments - not used.
   *@return Command line arguments - not used.
   */
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   /** 
   *works for getHigh temperature.
   *@param highIn Command line arguments - not used.
      *@return Command line arguments - not used.
      */
   public int higherMaximum(int highIn) { 
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
   /**
   *prints all to string. 
   *@return Command line argument - not used.
   */
   public String toString() { 
   
      return "\tTemperatures: " + temperatures
         + "\n\tLow: " + getLowTemp()
         + "\n\tHigh: " + getHighTemp();
   }
}