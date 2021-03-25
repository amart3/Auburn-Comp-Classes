/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class Outfielder extends SoftballPlayer { 

//Instance Variables
   private double outfielderFieldingAvg;

//Constructor 

/** 
*@param outfielderFieldingAvgIn for outfielderFieldingAvg.
*@param numberIn for number.
   *@param nameIn for name.
   *@param positionIn for position.
   *@param specializationFactorIn for specializationFactor.
   *@param battingAvgIn for battingAvg.
   */
   public Outfielder(String numberIn, String nameIn, String positionIn,
                           double specializationFactorIn, double battingAvgIn,
                               double outfielderFieldingAvgIn) {
                           
      super(numberIn, nameIn, positionIn, specializationFactorIn, battingAvgIn);
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   
   }
   
   //Methods 
   
   /**
   *@return outfielderFieldingAvg. 
   */
   public double getOutfielderFieldingAvg() { 
      return outfielderFieldingAvg; 
   }
   
   /**
   *@param outfielderFieldingAvgIn for outfielderFieldingAvg.
   */
   public void setOutfielderFieldingAvg(double outfielderFieldingAvgIn) { 
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   
   /**
   *@return rate.
   */
   public double rating() {
      double rate = BASE_RATING * getSpecializationFactor() * getBattingAvg()
         * getOutfielderFieldingAvg();
      return rate; 
   }
}