import java.io.IOException;
/**
*Project 11.
*@author Lawrence Martin
*@version 4/24/19
*/

public class SoftballPlayersPart3 {

/**
*@param args command line arguments for filename.
*/

   public static void main(String[] args) {
   
      if (args.length == 0) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else { 
         try { 
            SoftballTeam player3 = new SoftballTeam(); 
            player3.readPlayerFile(args[0]);
            System.out.println(player3.generateReport());
            System.out.println(player3.generateReportByNumber());
            System.out.println(player3.generateReportByName());
            System.out.println(player3.generateReportByRating()); 
            System.out.println(player3.generateExcludedRecordsReport());
         }
         catch (IOException fileProblem) {
            System.out.println("Attempted to read file: "
               + fileProblem.getMessage()); 
            System.out.println("Program ending."); 
         }
      }
   }
}