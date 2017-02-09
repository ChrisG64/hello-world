import java.util.Scanner;

/**
   To be provided by CSC 20 Students.
*/

public class CalcAverageForCsc20
{
   public static void main(String[] args)
   {
      // Variable To hold the number of scores
      int scores = 0;
      
      // Create a Scanner object for keyboard input.
      Scanner input = new Scanner(System.in);
            
      // Get the number of test scores.
      System.out.print("How many test scores do you have? ");
      scores = input.nextInt();
      
      // Check for number of scores input
      // If number of scores is less than 2, print an error and exit.
      // Otherwise, proceed with steps below.
      if(scores < 2)
      {
         System.out.println("Not enough test scores.");
         System.exit(0);
      }
      
           

      // Create an array to hold the test scores.
      double testScores[] = new double[scores];
      
      // Get the test scores and store them in the scores array.
      for(int i = 0; i <= testScores.length - 1; i++)
      {  
         System.out.print("Enter score #" + (i+1) + ": ");
         testScores[i] = input.nextDouble();
      }
        

      // Create a Csc20 Grader object, passing the scores array as an argument to the
      // constructor.
       Csc20Grader grades = new Csc20Grader(testScores);      
      // Display the adjusted average.
      System.out.println("Your adjusted average is " + grades.getAverage());
       
      
      // Display the lowest score.
      System.out.println("Your lowest test score was " + grades.getLowestScore());
      
   }
}