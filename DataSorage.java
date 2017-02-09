abstract class DataSorage implements Control 
{
   protected final int NUMBER_OF_CSC20_LABS = 5;
   public void column()
   {
      for(int row = 0; row < numRows; row++)
      {
         colArray[row] = m2Darray[row][columnOfInterest];
      }

   
   }
}