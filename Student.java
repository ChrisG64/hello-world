import java.util.*;

class Student
{
   private int SID;
   private int scores[][] = new int[15][6];
   
   public Student(int SID, int[][] scores)
   {
      this.SID = SID;
      this.scores = scores;
      
   }
   
   public int getSID()
   {
      return this.SID;
   }
   
   public void setSID(int value)
   {
      this.SID = value; 
   }
   
   public int[][] getScores()
   {
      return scores;
   }

   
   public void setScores(int[][] scores)
   {
      this.scores = scores;
   }
   
   
   
}   