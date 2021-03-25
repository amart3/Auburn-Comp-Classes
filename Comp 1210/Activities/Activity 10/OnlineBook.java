/** 
*Activity 9.
*@author Lawrence Martin.
*@version 3/30/19.
*/

public class OnlineBook extends OnlineTextItem { 
  
  //Instance Variables
   protected String author; 
   
  //Constructor 
  /**
  *@param nameIn for name.
  *@param priceIn price. 
  */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   
   //Methods
   /** 
   *@param authorIn for author. 
   *@return author. 
   */  
   public String setAuthor(String authorIn) { 
      author = authorIn;
      return author;
   }
   
   /** 
   *@return name + " - " + author + ": $" + price.
   */
   public String toString() { 
      return name + " - " + author + ": $" + price;
   }
}