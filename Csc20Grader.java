public class Csc20Grader
{
   // The testScores field is a variable
   // that will reference an array
   // of test scores.
   private double[] testScores;

   /**
      Constructor
      scoreArray An array of test scores.
   */
   
   public Csc20Grader(double[] scoreArray)
   {
      // Assign the array argument to
      // the testScores field.
      testScores = scoreArray;
   }
   
   /**
      getLowestScore method
      return The lowest test score.
   */
   
   public double getLowestScore()
   {
      int lowest = (int)testScores[0];
      for(int i = 0; i < testScores.length; i++)
      {
         if(lowest > testScores[i])
         {
            lowest = (int)testScores[i];
         }
         continue;
      }
      return lowest;
   }
   
   /**
      getAverage method 
      return The average of the test scores
              with the lowest score dropped.

      Important Note: 
      If the array contains less than two test
      scores, display an error message and set average to 0.
              
   */
   
   public double getAverage()
   {
      double sum = 0;
      double average = 0;
      if(testScores.length < 2)
      {
         System.out.println("Not enough test scores to compute an average.");
         return average;
      }
      for(int i = 0; i < testScores.length; i++)
      {
         
         sum = sum + testScores[i];
      }
      average = (sum - getLowestScore()) / (testScores.length - 1);
      return average;

   }
}