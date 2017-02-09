import java.util.*;
class LabAverages
{
   public static void main(String[] args)
   {
      int studArr[][] = new int[15][6];
      studArr = ReadTextFile.readData("labData.txt", studArr);
      ReadTextFile.printData("labData.txt");
      Stats stat = new Stats(studArr);
      stat.calculateLow(studArr);
      stat.calculateHigh(studArr);
      stat.calculateAvg(studArr);
     
   }
}