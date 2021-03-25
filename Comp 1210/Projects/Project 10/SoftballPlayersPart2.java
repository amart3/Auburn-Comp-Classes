import java.io.IOException;
/**
*Project 9.
*@author Lawrence Martin.
*@version 4/1/19
*/

public class SoftballPlayersPart2 {

/**
* @param args command line arguments for filename.
* @throws IOException if no file.
*/
   public static void main(String[] args) throws IOException
   {
      SoftballTeam sBTeam = new SoftballTeam(); 
      if (args.length == 0) {
      
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
         return;
      }
      else {
       
         sBTeam.readPlayerFile(args[0]);
         
         System.out.println(sBTeam.generateReport());
         System.out.println(sBTeam.generateReportByNumber());
         System.out.println(sBTeam.generateReportByName());
         System.out.println(sBTeam.generateReportByRating());
         System.out.println(sBTeam.generateExcludedRecordsReport());
      } 
   }
}
   
