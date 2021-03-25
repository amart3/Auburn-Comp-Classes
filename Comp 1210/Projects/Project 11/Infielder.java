/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class Infielder extends SoftballPlayer {

//Instance Varibles
   private double infielderFieldingAvg;

//Constructor
   /**
   *@param numberIn for number.
   *@param nameIn for name.
   *@param positionIn for position.
   *@param specializationFactorIn for specializationFactor.
   *@param battingAvgIn for battingAvg.
   *@param infielderFieldingAvgIn for infielderFieldingAvg.
   */ 
   public Infielder(String numberIn, String nameIn, String positionIn,
                           double specializationFactorIn, double battingAvgIn,
                            double infielderFieldingAvgIn) {
                           
      super(numberIn, nameIn, positionIn, specializationFactorIn, battingAvgIn);
      infielderFieldingAvg = infielderFieldingAvgIn;
   }
   
//Methods 

/**
*@return infielderFieldingAvg. 
*/ 
   public double getInfielderFieldingAvg() { 
      return infielderFieldingAvg; 
   }
   
   /**
   *@param infielderFieldingAvgIn for infielderFieldingAvg.
   */
   public void setInfielderFieldingAvg(double infielderFieldingAvgIn) {
      infielderFieldingAvg = infielderFieldingAvgIn; 
   }

    /** 
    *@return rating. 
    */ 
   public double rating() {
      double rate = BASE_RATING * getSpecializationFactor() * getBattingAvg()
         * getInfielderFieldingAvg();
      return rate; 
   }
}