import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ReadTextFile 
{
   public static int[][] readData(String file, int data[][])
   {
      try
      {
         BufferedReader br = new BufferedReader(new FileReader(file));
         br.readLine();
         String read = null;
         String[] arr;
         int count = 0;
         while((read = br.readLine()) != null)
         {
            for(int x = 0; x < 15; x++)
            {
               arr = read.split(" ");
                  while(count != arr.length)
                  { 
                     for(int y = 0; y <= 5; y++)
                     {
                        data[x][y] = Integer.parseInt(arr[count]);
                        count++;
                     }
                  }
                  count = 0;
                  read = br.readLine();
            }   
            
         }
         br.close();
       }
       catch(IOException e)
       {
         System.out.println("Error " + e.toString());
       }
       return data;
    }
   
   public static void printData(String file)
   {
      try  
      {
         BufferedReader br = new BufferedReader(new FileReader(file));
         String line = null;
         while ((line = br.readLine()) != null)
         {
            System.out.println(line);
         }
         System.out.println("");
      } 
      catch(IOException e)
      {
         System.out.println("Error " + e.toString());
      }
   
   }
}   
       
         