import java.util.Comparator;
/**
*Project 10.
*@author Lawrence Martin
*@version 4/8/19.
*/
public class NameComparator implements Comparator<SoftballPlayer> {

/**
*@return an int.
*@param p1 player1
*@param p2 player2
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {
   
      int index1 = p1.getName().indexOf(" "); 
      String firstName1 = p1.getName().substring(0, index1); 
      String lastName1 = p1.getName().substring(index1 + 1); 
   
      int index2 = p2.getName().indexOf(" "); 
      String firstName2 = p2.getName().substring(0, index2); 
      String lastName2 = p2.getName().substring(index2 + 1); 
   
      return Integer.signum((lastName1 
         + firstName1).toUpperCase().compareTo((lastName2
         + firstName2).toUpperCase()));   
   }
}