import java.util.Scanner;

/**
 *Activity 4b.
 *@author Lawrence Martin.
 *@version 2/11/19 
 */
public class GradeGenerator {

   /**
    * Gets username and averrage of quizzes. 
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      double actvAvg, quizAvg, projAvg, exam1Score, 
         exam2Score, finalExamScore;
      String name;
      Grade comp1210Grade;
      Scanner stdInReader = new Scanner(System.in);
      
   	//gets name
      System.out.print("Enter your name: ");
      name = stdInReader.nextLine();
   	
   	// gets activity, quiz and project averages. 
      System.out.print("Enter your activity average: ");
      actvAvg = Double.parseDouble(stdInReader.nextLine());
      System.out.print("Enter your quiz average: ");
      quizAvg = Double.parseDouble(stdInReader.nextLine());
      System.out.print("Enter your project average: ");
      projAvg = Double.parseDouble(stdInReader.nextLine());
      
   	//gets input for exams
      System.out.print("Enter your exam 1 score: ");
      exam1Score = Double.parseDouble(stdInReader.nextLine());
      System.out.print("Enter your exam 2 score: ");
      exam2Score = Double.parseDouble(stdInReader.nextLine());
      System.out.print("Enter your final exam score: ");
      finalExamScore = Double.parseDouble(stdInReader.nextLine());
      
      //Creates grade object.
      comp1210Grade = new Grade(name); 
            	
   	
   	//set lab averages for activity and quiz
      comp1210Grade.setLabAverages(actvAvg, quizAvg);
      
      //set project average. 
      comp1210Grade.setProjectAvg(projAvg);
   	
   	//set exam scores
      comp1210Grade.setExamScore(Grade.EXAM_1, exam1Score);
      comp1210Grade.setExamScore(Grade.EXAM_2, exam2Score);
      comp1210Grade.setExamScore(Grade.FINAL, finalExamScore);
      
      // calculate COMP 1210 grade
      double courseAvg = comp1210Grade.calculateGrade();
   	// print out COMP 1210   
      System.out.print("Your average for COMP 1210 is: "
                  + courseAvg);
   }
}