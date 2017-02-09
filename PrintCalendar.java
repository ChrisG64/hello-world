import java.util.Calendar;
public class PrintCalendar
{
   private int year;
   private final JulianDate jd = new JulianDate();

public static void main(String[] args) 
{
   int inputYear;
   // Obtain input year integer value
   if(args.length == 0)
   {
      inputYear = Calendar.getInstance().get(Calendar.YEAR);
   }
   else
   {
      inputYear = Integer.parseInt(args[0]);  
   }
   // Create a calendar object
   PrintCalendar myCal = new PrintCalendar(inputYear); 
   myCal.printYear();
}
	
public PrintCalendar(int inputYear)
{
   this.year = inputYear;
}
	
public void printYear() 
{
   // Label the year
   System.out.printf("%13s\n", this.year); 
   // Repeat 12 times to print a month
   for(int month = 1; month <= 12; month++)
   {
      printMonth(month, year);
   } 
}
	
private void printMonth(int month, int year) 
{
   // Label the input month i.e January
   int numberOfDaysInMonth = 0;
   if((Calendar.getInstance().get(Calendar.MONTH) + 1) == month && Calendar.getInstance().get(Calendar.YEAR) == year)
   {
      System.out.printf(" ---------------------");
   }
   switch(month)
   {
      case 1:
         System.out.printf("\n%15s\n\n", "January");
         numberOfDaysInMonth = 31;
         break;
      case 2:
         System.out.printf("\n%15s\n\n", "February");
         numberOfDaysInMonth = getFebruaryDays();
         break;
      case 3:
         System.out.printf("\n%15s\n\n", "March");
         numberOfDaysInMonth = 31;
         break;
      case 4:
         System.out.printf("\n%15s\n\n", "April");
         numberOfDaysInMonth = 30;
         break;
      case 5:
         System.out.printf("\n%15s\n\n", "May");
         numberOfDaysInMonth = 31;
         break;
      case 6:
         System.out.printf("\n%15s\n\n", "June");
         numberOfDaysInMonth = 30;
         break;
      case 7:
         System.out.printf("\n%15s\n\n", "July");
         numberOfDaysInMonth = 31;
         break;
      case 8:
         System.out.printf("\n%15s\n\n", "August");
         numberOfDaysInMonth = 31;
         break;
      case 9:
         System.out.printf("\n%15s\n\n", "September");
         numberOfDaysInMonth = 30;
         break;
      case 10:
         System.out.printf("\n%15s\n\n", "October");
         numberOfDaysInMonth = 31;
         break;
      case 11:
         System.out.printf("\n%15s\n\n", "November");
         numberOfDaysInMonth = 30;
         break;
      case 12:
         System.out.printf("\n%15s\n\n", "December");
         numberOfDaysInMonth = 31;
         break;
    }
             
   // Label Days of the week i.e S M Tu W Th F S
   this.printDaysOfWeek();
   // Print days numbers i.e. 1 2 3 ...
   this.printDayNumbers(month, year);
}

private void printDaysOfWeek()
{	
   // print label days of the week i.e S M Tu W Th F S
   System.out.printf("%3s", "S");
   System.out.printf("%3s", "M");
   System.out.printf("%3s", "Tu");
   System.out.printf("%3s", "W");
   System.out.printf("%3s", "Th");
   System.out.printf("%3s", "F");
   System.out.printf("%3s\n", "S");
}

private void printDayNumbers(int month, int year)
{
   // Determine number of days
   int firstDayOfMonth = ((jd.toJulian(year, month, 1) + 1)% 7) + 1;
   // Compute the 1st day of the month then position the 1st day for displaying
   if(firstDayOfMonth > 1)
   {
      System.out.printf("\n");
      System.out.printf("%" + ((firstDayOfMonth - 1) * 3) + "c", ' ');
      
   }
   int currentDay = firstDayOfMonth;
   for(int j = 1; j <= getNumberOfDays(month); j++)
   {
      System.out.printf("%3s", j);
      if(currentDay == 7)
      {
         System.out.print("\n");
         currentDay = 0;
      }
      currentDay++;
   }
   if((Calendar.getInstance().get(Calendar.MONTH) + 1) == month && Calendar.getInstance().get(Calendar.YEAR) == year)
   {
      System.out.printf("\n");
      System.out.printf(" ---------------------");
   }
   System.out.print("\n\n");
}
  

        
// Get number of days for a month        
//Method that returns the number of days for each month
private int getNumberOfDays (int month)   {
      int numberOfDays=0;
      //Switch statement that uses the month number to return the days for each month
      switch (month)
      {
         case 1: numberOfDays = 31;
            break;
         //Becuase February is sometimes 29 days, we have to call a seperate method for it
         case 2: numberOfDays = getFebruaryDays();
            break;
         case 3: numberOfDays = 31;
            break;
         case 4: numberOfDays = 30;
            break;
         case 5: numberOfDays = 31;
            break;
         case 6: numberOfDays = 30;
            break;
         case 7: numberOfDays = 31;
            break;
         case 8: numberOfDays = 31;
            break;
         case 9: numberOfDays = 30;
            break;
         case 10: numberOfDays = 31;
            break;
         case 11: numberOfDays = 30;
            break;
         case 12: numberOfDays = 31;
            break;
      }
      return numberOfDays;
}

        
private int getFebruaryDays()
{
   int n=28;
   if(year%4==0 && (year%100!=0 || year%400==0))
   {
      n++;
   }
   
   return n; 
     	
}

} // End of PrintCalendar