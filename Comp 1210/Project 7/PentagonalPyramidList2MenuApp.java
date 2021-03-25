import java.util.Scanner; 
import java.io.FileNotFoundException;
/** 
*Project 7.
*@author Lawrence Martin
*@version 2/27/19
*class with a main method that presents
   *the user with a menu with eight options.
*/

public class PentagonalPyramidList2MenuApp {
/**
*@param args - is not used.
*@throws FileNotFoundException if file cannot be opened. 
*/

   public static void main(String[] args) throws FileNotFoundException { 
      String pList = "*** no list name assigned ***";
      PentagonalPyramid[] pList2 = new PentagonalPyramid[20];
      PentagonalPyramidList2 pentaList = 
            new PentagonalPyramidList2(pList, pList2, 0);
      
      String fileName = "no file name";
      String label = ""; 
      double baseEdge = 0;
      double height = 0; 
      String userInput = "";
      
      Scanner scanInput = new Scanner(System.in); 
      System.out.println("PentagonalPyramid List System Menu\n"
                    + "R - Read File and Create PentagonalPyramid List\n"
                    + "P - Print PentagonalPyramid List\n"
                    + "S - Print Summary\n"
                    + "A - Add PentagonalPyramid\n" 
                    + "D - Delete PentagonalPyramid\n"
                    + "F - Find PentagonalPyramid\n" 
                    + "E - Edit PentagonalPyramid\n"
                    + "Q - Quit");
      do { 
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         userInput = scanInput.nextLine();
         if (userInput.length() == 0) { 
            continue;
         }
         userInput = userInput.toUpperCase();
         char userChar = userInput.charAt(0);
         
         switch (userChar) { 
            case 'R': // Read in File and Create PentagonalPyramid.
               System.out.print("\tFile Name: ");
               fileName = scanInput.nextLine(); 
            
               pentaList = pentaList.readFile(fileName);
               System.out.println("\tFile read in and PentagonalPyramid"
                  + " List created\n");
            
               break;
         
            case 'P': //Prints PentagonalPyramid list.
               System.out.println(pentaList);
            
               break;
         
            case 'S': //Prints PentagonalPyramid summary.
               System.out.println("\n" + pentaList.summaryInfo() + "\n"); 
            
               break; 
         
            case 'A': //Add PentagonalPyramid list.
               System.out.print("\tLabel: "); 
               label = scanInput.nextLine(); 
            
               System.out.print("\tBase Edge: "); 
               baseEdge = Double.parseDouble(scanInput.nextLine()); 
            
               System.out.print("\tHeight: "); 
               height = Double.parseDouble(scanInput.nextLine());
               
            
               pentaList.addPentagonalPyramid(label, baseEdge, height); 
               System.out.println("\t*** PentagonalPyramid added ***\n"); 
            
               break; 
         
            case 'D': //Deletes PentagonalPyramid object.
               System.out.print("\tLabel: "); 
               label = scanInput.nextLine();
               PentagonalPyramid java 
                  = pentaList.deletePentagonalPyramid(label); 
            
               if (java != null) {
                  System.out.println("\t\"" + java.getLabel() 
                                                + "\" deleted\n"); 
               }
               else { 
                  System.out.println("\t\"" + label + "\" not found\n"); 
               } 
               break; 
         
            case 'F': //finds PentagonalPyramid object.
               System.out.print("\tLabel: "); 
               label = scanInput.nextLine(); 
               if (pentaList.findPentagonalPyramid(label) != null) { 
                  System.out.println(pentaList.findPentagonalPyramid(label)
                                                .toString() + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
            
               break; 
         
            case 'E': //edits PentagonalPyramid object.
            
               System.out.print("\tLabel: "); 
               label = scanInput.nextLine(); 
            
               System.out.print("\tBase Edge: "); 
               baseEdge = Double.parseDouble(scanInput.nextLine()); 
            
               System.out.print("\tHeight: "); 
               height = Double.parseDouble(scanInput.nextLine());
            
            
               if (pentaList.findPentagonalPyramid(label) != null) { 
                  pentaList.editPentagonalPyramid(label, baseEdge, height); 
                  System.out.println("\t\"" + label 
                                                + "\" successfully edited\n");
               }
               else {
                  System.out.print("\t\"" + label + "\" not found\n\n"); 
               }
               break;
         
            case 'Q': //Quit
               break;
         
            default:
               System.out.println("\t*** invalid code ***\n");
         }
        
      } while (!userInput.equalsIgnoreCase("Q"));
   }
}
   

