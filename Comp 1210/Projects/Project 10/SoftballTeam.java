import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.text.DecimalFormat;
/**
*Project 10. 
*@author Lawrence Martin.
*@version 4/8/19.
*/

public class SoftballTeam { 

//Instance Variables 
   private String teamName; 
   private SoftballPlayer[] roster = new SoftballPlayer[24];
   private int playerCount; 
   private String[] excludedRecords = new String[30];
   private int excludedCount;
   private int ignoredCount; 
    

//Class Variables
   private static int teamCount; 
  
   /**
   *
   */
   public static final int MAX_PLAYERS = 24;
   
   /**
   *
   */
   public static final int  MAX_EXCLUDED = 30;
 
//Constructor
/** 
*
*/
   public SoftballTeam() { 
      teamCount++; 
      setTeamName(teamName); 
      setRoster(roster); 
      setPlayerCount(playerCount); 
      setExcludedRecords(excludedRecords);
      setExcludedCount(excludedCount); 
      setIgnoredCount(ignoredCount); 
   }


//Methods
   
   /**
   *@return teamName.
   */
   public String getTeamName() { 
      return teamName;
   }
   
   /**
   *@param teamNameIn for teamName. 
   */
   public void setTeamName(String teamNameIn) { 
      teamName = teamNameIn;
   }
   
   /**
   *@return roster.
   */
   public SoftballPlayer[] getRoster() { 
      return roster;
   }
   
   /**
   *@param rosterIn for roster.
   */
   public void setRoster(SoftballPlayer[] rosterIn) { 
      roster = rosterIn;
   }
   
   /**
   *@return playerCount.
   */
   public int getPlayerCount() { 
      return playerCount; 
   } 
   
   /**
   *@param playerCountIn for playerCount/
   */
   public void setPlayerCount(int playerCountIn) {
      playerCount = playerCountIn; 
   }
   
   /**
   *@return excludedRecords.
   */
   public String[] getExcludedRecords() { 
      return excludedRecords;
   }
   
   /**
   *@param excludedRecordsIn for excludedRecords.
   */
   public void setExcludedRecords(String[] excludedRecordsIn) { 
      excludedRecords = excludedRecordsIn; 
   }
   
   /**
   *@return excludedCount.
   */
   public int getExcludedCount() { 
      return excludedCount; 
   } 
   
   /**
   *@param excludedCountIn for excludedCount.
   */
   public void setExcludedCount(int excludedCountIn) { 
      excludedCount = excludedCountIn; 
   }
   
   /**
   *@return ignoredCount. 
   */
   public int getIgnoredCount() { 
      return ignoredCount; 
   } 
   
   /**
   *@param ignoredCountIn for ignoredCount.
   */
   public void setIgnoredCount(int ignoredCountIn) { 
      ignoredCount = ignoredCountIn; 
   }
   
   /**
   *@return teamCount.
   */
   public static int getTeamCount() { 
      return teamCount;
   }
   
   /**
   *teamCount = 0.
   */
   public static void resetTeamCount() { 
      teamCount = 0;
   }
   
   /**
   *@throws IOException if no file.
   *@param fileName for files.
   */
   public void readPlayerFile(String fileName) throws IOException {
      Scanner scanFile = new Scanner(new File(fileName));
      Scanner scanLines;
      teamName = scanFile.nextLine();
      while (scanFile.hasNextLine()) {
         String line = scanFile.nextLine();
         scanLines = new Scanner(line);
         scanLines.useDelimiter(",");
         String type = scanLines.next();
         char ctype = type.charAt(0);
         String number = scanLines.next();
         String name = scanLines.next();
         String position = scanLines.next();
         double specializationFactor = Double.parseDouble(scanLines.next());
         double battingAvg = Double.parseDouble(scanLines.next());
         switch (ctype)
         {
            case 'O':
               double outfielderFieldingAvg = Double.parseDouble(
                                             scanLines.next());
               Outfielder player = new Outfielder(number, name, position,
                       specializationFactor, battingAvg, outfielderFieldingAvg);
               if (playerCount < MAX_PLAYERS)
               {
                  roster[playerCount] = player;
                  playerCount++;
               }
               else if (excludedCount < MAX_EXCLUDED)
               {
                  excludedRecords[excludedCount] = "Maximum player count of" 
                                     + " 24 exceeded for: " + line; 
                  excludedCount++;
               }
               else {
                  ignoredCount++;
               }
               break;
               
            case 'I': 
               
               double infielderFieldingAvg = Double.parseDouble(
                                          scanLines.next());
               Infielder player2 = new Infielder(number, name, position,
                       specializationFactor, battingAvg, infielderFieldingAvg);
               if (playerCount < MAX_PLAYERS)
               {
                  roster[playerCount] = player2;
                  playerCount++;
               }
               else if (excludedCount < MAX_EXCLUDED)
               {
                  excludedRecords[excludedCount] = "Maximum player count of"
                                     + " 24 exceeded for: " + line; 
                  excludedCount++;
               }
               else {
                  ignoredCount++;
               }
               break;
               
            case 'P':
               int wins = Integer.parseInt(scanLines.next());
               int losses = Integer.parseInt(scanLines.next());
               double era = Double.parseDouble(scanLines.next());
               Pitcher player3 = new Pitcher(number, name, position, 
                  specializationFactor, battingAvg, wins, losses, era);
               if (playerCount < MAX_PLAYERS)
               {
                  roster[playerCount] = player3;
                  playerCount++;
               }
               else if (excludedCount < MAX_EXCLUDED)
               {
                  excludedRecords[excludedCount] = "Maximum player count of"
                                      + " 24 exceeded for: " + line; 
                  excludedCount++;
               }
               else {
                  ignoredCount++;
               }
               break; 
                                     
            case 'R':
               int wins2 = Integer.parseInt(scanLines.next());
               int losses2 = Integer.parseInt(scanLines.next());
               double era2 = Double.parseDouble(scanLines.next());
               int saves = Integer.parseInt(scanLines.next());
               ReliefPitcher player4 = new ReliefPitcher(number, name, position,
                  specializationFactor, battingAvg, wins2, losses2, era2, 
                     saves);
               if (playerCount < MAX_PLAYERS)
               {
                  roster[playerCount] = player4;
                  playerCount++;
               }
               else if (excludedCount < MAX_EXCLUDED)
               {
                  excludedRecords[excludedCount] = "Maximum player count of"
                                         + " 24 exceeded for: " + line;
                  excludedCount++;
               }
               else {
                  ignoredCount++;
               }
               break;
               
            default: 
               if (excludedCount < MAX_EXCLUDED)
               {
                  excludedRecords[excludedCount] = "*** invalid category *** " 
                      + line;
                  excludedCount++;
               }
               else {
                  ignoredCount++;
               }
         }
      }
   }

   /**
   *@return output.
   */   
   public String generateReport() {
      String output = "\n---------------------------------------\n";
      output += "Team Report for ";
      output += teamName + "\n---------------------------------------\n\n";
      for (int i = 0; i < playerCount - 1; i++)
      {
         output += roster[i] + "\n\n";
      }
      output += roster[playerCount - 1] + "\n";
      return output;
   }
   
   /**
   *@return string.
   */   
   public String generateReportByNumber() {
      String output = "\n---------------------------------------\n";
      output += "Team Report for " + teamName + " (by Number)";
      output += "\n---------------------------------------\n";
      SoftballPlayer[] s = Arrays.copyOf(roster, playerCount);
      Arrays.sort(s);
      for (int i = 0; i < playerCount - 1; i++)
      {
         output += s[i].getNumber();
         output += " " + s[i].getName();
         output += " " + s[i].getPosition();
         output += " " + s[i].stats() + "\n";
      }
      output += s[playerCount - 1].getNumber();
      output += " " + s[playerCount - 1].getName();
      output += " " + s[playerCount - 1].getPosition();
      output += " " + s[playerCount - 1].stats();
      return output;
   }
   
   /**
   *@return string.
   */   
   public String generateReportByName() {
      String output = "\n---------------------------------------\n";
      output += "Team Report for " + teamName + " (by Name)";
      output += "\n---------------------------------------\n";
      NameComparator ncomp = new NameComparator();
      SoftballPlayer[] s = Arrays.copyOf(roster, playerCount);
      Arrays.sort(s, ncomp);
      for (int i = 0; i < playerCount - 1; i++)
      {
         output += s[i].getNumber();
         output += " " + s[i].getName();
         output += " " + s[i].getPosition();
         output += " " + s[i].stats() + "\n";
      }
      output += s[playerCount - 1].getNumber();
      output += " " + s[playerCount - 1].getName();
      output += " " + s[playerCount - 1].getPosition();
      output += " " + s[playerCount - 1].stats();
      return output;
   }
   
   /**
   *@return string.
   */   
   public String generateReportByRating() {
      DecimalFormat df = new DecimalFormat("0.000");
      String output = "\n---------------------------------------\n";
      output += "Team Report for " + teamName + " (by Rating)";
      output += "\n---------------------------------------\n";
      
      RatingComparator rcomp = new RatingComparator();
      SoftballPlayer[] s = Arrays.copyOf(roster, playerCount);
      Arrays.sort(s, rcomp);
      for (int i = 0; i < playerCount - 1; i++)
      {
         output += df.format(s[i].rating());
         output += " " + s[i].getNumber();
         output += " " + s[i].getName();
         output += " " + s[i].getPosition();
         output += " " + s[i].stats() + "\n";
      }
      output += df.format(s[playerCount - 1].rating());
      output += " " + s[playerCount - 1].getNumber();
      output += " " + s[playerCount - 1].getName();
      output += " " + s[playerCount - 1].getPosition();
      output += " " + s[playerCount - 1].stats();
      
      return output;
   }
   
 /**.
   * @return string.
   */     
   public String generateExcludedRecordsReport() {
      String output = "\n---------------------------------------\n";
      output += "Excluded Records Report\n";
      output += "---------------------------------------\n";
      for (int i = 0; i < excludedCount; i++)
      {
         output += excludedRecords[i] + "\n";
      }
      return output + "Number of ignored records from file: " + ignoredCount;
   }
}