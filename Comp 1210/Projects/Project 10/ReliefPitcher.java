/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class ReliefPitcher extends Pitcher {

//Instance Variables

   private int saves; 

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
      *@param savesIn for saves.
      */
   public ReliefPitcher(String numberIn, String nameIn, String positionIn,
                           double specializationFactorIn, double battingAvgIn,
                           int winsIn, int lossesIn,
                               double eraIn, int savesIn) { 
   
      super(numberIn, nameIn, positionIn, specializationFactorIn, battingAvgIn,
         winsIn, lossesIn, eraIn); 
   
      saves = savesIn;
   }

//Methods 

   /**
   *@return saves.
   */
   public int getSaves() { 
      return saves; 
   } 

   /**
   *@param savesIn for saves.
   */
   public void setSaves(int savesIn) { 
      saves = savesIn; 
   }
   
   /**
   *@return wins + "wins" + losses + "losses" + saves + "saves" + era + "ERA".
   */
   public String stats() { 
      return wins + " wins, " + losses + " losses, "
         + saves + " saves, " + era + " ERA"; 
   }
   
   /**
   *@return rate.
   */
   public double rating() { 
      double rate = BASE_RATING * specializationFactor *  (1 / (1 + era))
             * ((wins - losses + saves) / 30.0);
      return rate;
   } 
}