class Stats 
{
   private static final int NUMBER_OF_CSC20_LABS = 5;
   private int[] lowscores = new int[NUMBER_OF_CSC20_LABS];
   private int[] highscores = new int[NUMBER_OF_CSC20_LABS];
   private static float[] avgscores = new float[NUMBER_OF_CSC20_LABS];
   int scores[][] = new int[15][6];
   
   public Stats(int[][] scores)
   {
      this.scores = scores;
   }
   
   public void setAvgScores(float[] avgscores)
   {
      this.avgscores = avgscores;
   }
   
   
   public static void calculateLow(int[][] a)
   {
      int count = 1;
      int lab[] = new int[15];
      lab = labColumns(a, count);
      int minValue = lab[0];
      System.out.print("Low Score: ");
      while(count <= 5)
      { 
         
         for(int i = 0; i < lab.length; i++)
         {
            if(lab[i] < minValue)
            {
               minValue = lab[i];
            }
         }
         System.out.print(minValue + " ");
         count++;
         minValue = 100;
         if(count != 6)
         {
            lab = labColumns(a, count);
         }
         else{break;}
      }
      System.out.println("");
   }
   
   public static void calculateHigh(int[][] a)
   {
      int count = 1;
      int lab[] = new int[15];
      lab = labColumns(a, count);
      int maxValue = lab[0];
      System.out.print("High Score: ");
      while(5 >= count)
      { 
         
         for(int i = 0; i < lab.length; i++)
         {
            if(lab[i] > maxValue)
            {
               maxValue = lab[i];
            }
         }
         System.out.print(maxValue + " ");
         count++;
         maxValue = 0;
         if(count != 6)
         {
            lab = labColumns(a, count);
         }
         else{break;}
         

      }
      System.out.println("");

     
   }
   
   public static void calculateAvg(int[][] a)
   {
       int sum = 0;
       int count = 1;
       int lab[] = new int[15];
       float averagescores[] = new float[5];
      lab = labColumns(a, count);
      System.out.print("Average: ");

       
       while(count <= 5)
       {        
               sum = 0;
                for(int i= 0; i < lab.length ; i++)
                {
                        sum = sum + lab[i];
                }
               
                //calculate average value
                averagescores[count-1] = sum / lab.length;
                System.out.print(averagescores[count-1] + " ");
                count++;
                if(count != 6)
                {
                  lab = labColumns(a, count);
                }
                else{break;}
          
       }
       System.out.println("");
   }
   

   



         
   private static int[] labColumns(int scores[][], int labnumber)
   { 
      int lab[] = new int[15]; 
      for(int row = 0; row < lab.length; row++)
      {
         lab[row] = scores[row][labnumber];
      }
      return lab;
   }
}
      