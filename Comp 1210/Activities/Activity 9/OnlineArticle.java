/** 
*Activity 9.
*@auth0r Lawrence Martin.
*@version 3/30/19.
*/

public class OnlineArticle extends OnlineTextItem { 
  //Instance Variables
   private int wordCount; 

//Constructor 
/**
*@param nameIn for name.
*@param priceIn for price.
*/
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn); 
      wordCount = 0;
   }
   //Methods 
   /**
   *@param wordCountIn for wordCount.
   *@return wordCount.
   */
   public int setWordCount(int wordCountIn) { 
      wordCount = wordCountIn; 
      return wordCount;
   }
}
