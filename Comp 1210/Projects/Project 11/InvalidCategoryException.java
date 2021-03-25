/**
*Project 11.
*@author Lawrence Martin.
*@version 4/19/2019
*/

public class InvalidCategoryException extends Exception { 
   
   /**
   *@param category for category.
   */
   public InvalidCategoryException(String category)  { 
   
      super("For category: " + "\"" + category + "\"");
   }

}