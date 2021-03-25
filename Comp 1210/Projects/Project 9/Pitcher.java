/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class Pitcher extends SoftballPlayer {

//Instance Variables 
   protected int wins; 
   protected int losses;
   protected double era; 

//Constructor 
   
      /**
      *@param numberIn for number.
      *@param nameIn for name.
      *@param positionIn for position.
      *@param specializationFactorIn for specializationFactor.
      *@param battingAvgIn for battingAvg.
      *@param winsIn for wins.
      *@param lossesIn for lsses. 
      *@param eraIn for era. 
      */ 
   public Pitcher(String numberIn, String nameIn, String positionIn,
                           double specializationFactorIn, double battingAvgIn,
                           int winsIn, int lossesIn, double eraIn) {
      super(numberIn, nameIn, positionIn, specializationFactorIn, battingAvgIn);
      wins = winsIn;
      losses = lossesIn;
      era = eraIn; 
   }
   
   //Methods 
   
   /**
   *@return wins.
   */
   public int getWins() { 
      return wins;
   }
   
   /**
   *@param winsIn for wins. 
   */ 
   public void setWins(int winsIn) { 
      wins = winsIn; 
   }
   
   /**
   *@return losses.
   */
   public int getLosses() { 
      return losses; 
   }
   
   /**
   *@param lossesIn for losses.
   */
   public void setLosses(int lossesIn) { 
      losses = lossesIn;
   }
   
   /**
   *@return era.
   */
   public double getEra() { 
      return era;
   }
   
   /**
   *@param eraIn for era.
   */
   public void setEra(double eraIn) { 
      era = eraIn; 
   }
   
   /**
   *@return rate.
   */
   public double rating() {
      double rate = BASE_RATING * getSpecializationFactor() *  (1 / (1 
               + era)) * ((wins - losses) / 25.0);
      return rate; 
   }
   
   /**
   *@return wins + "wins" + losses + "losses" + era + "ERA";
   */
   public String stats() { 
      return wins + " wins, " + losses + " losses, " + era + " ERA"; 
   }

}

