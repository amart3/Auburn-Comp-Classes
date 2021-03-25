import java.text.DecimalFormat;
/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public abstract class SoftballPlayer implements Comparable<SoftballPlayer> {

//Instance Variables
   protected String number, name, position;
   protected double specializationFactor;
   protected double battingAvg;
   //Class Variable
   protected static int count = 0;
   /**
   *
   */
   public static final int BASE_RATING = 10;
   
   //Constructor
   /**
   *@param numberIn for number.
   *@param nameIn for name.
   *@param positionIn for position.
   *@param specializationFactorIn for specializationFactor.
   *@param battingAvgIn for battingAvg.
   */
   
   public SoftballPlayer(String numberIn, String nameIn, String positionIn,
                           double specializationFactorIn, double battingAvgIn) {
      number = numberIn;
      name = nameIn; 
      position = positionIn; 
      battingAvg = battingAvgIn; 
      specializationFactor = specializationFactorIn;
      count++; 
   }
   
   //Methods
  
   /** 
   *@return number.
   */
   public String getNumber() { 
      return number; 
   }
   
   /**
   *@param numberIn for number
   */
   public void setNumber(String numberIn) { 
      number = numberIn; 
   }
   
   /** 
   *@return name. 
   */
   public String getName() {
      return name;
   } 
   
   /**
   *@param nameIn for name.
   */
   public void setName(String nameIn) {
      name = nameIn; 
   } 
   
   /** 
   *@return position.
   */
   public String getPosition() { 
      return position; 
   }
   
   /** 
   *@param positionIn for position.
   */
   public void setPosition(String positionIn) { 
      position = positionIn;
   }
   
   /** 
   *@return battingAvg.
   */
   public double getBattingAvg() {
      return battingAvg;
   }
   
   /**
   *@param battingAvgIn for battingAvg.
   */
   public void setBattingAvg(double battingAvgIn) {
      battingAvg = battingAvgIn; 
   }
   
   /** 
   *@return specializationFator.
   */
   public double getSpecializationFactor() {
      return specializationFactor;
   }
   
   /**
   *@param specializationFactorIn for specializationFactor.
   */
   public void setSpecializationFactor(double specializationFactorIn) { 
      specializationFactor = specializationFactorIn;
   }
   
   /**
   *@return count.
   */
   public static int getCount() { 
      return count;
   }
   
   /**
   *count = 0.
   */
   public static void resetCount() { 
      count = 0;
   }
   
   /**
   *@return dForm.format(getBattingAvg()).
   */
   public String stats() { 
      DecimalFormat dForm = new DecimalFormat(".000");
      return dForm.format(getBattingAvg());
   }
   
   /** 
   *@return output.
   */ 
   public String toString() { 
      DecimalFormat dForm = new DecimalFormat(".000");
      String output = number + " " + name + " ("
         + position + ") " + stats() + "\n";
      output += "Specialization Factor: " + specializationFactor + " (" 
         + this.getClass() + ") Rating: " + dForm.format(rating());
      return output;
   }
   
   /**
   *@return rating;
   */
   public abstract double rating();
   
   /**
   *@param obj for obj.
   *@return int. 
   */
   public int compareTo(SoftballPlayer obj) {
      return number.compareTo(obj.number); 
   } 
}
