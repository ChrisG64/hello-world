/*                Reverse Hangman:
This program plays a reverse game of hangman in which the computer tries
to guess the letters of a word that the user chooses.
 
 Christopher Gomes
 Sacramento State
 CSC15
*/

import java.util.*;

public class ReverseHangman
{
   public static final int MAX_INCORRECT_GUESSES = 6;
    public static final int MAX_LENGTH = 8;
    public static final String LETTERS = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
    public static void main(String[] args)
    {
        boolean morePlayer = true;
        Scanner console = new Scanner(System.in);
         
        while(morePlayer)
        {
              int totalPlay =0;
              int totalWin =0;
              giveIntro();
              boolean more = true;
              while(more)
              {
              
                 int letters = getLengthWord(console);
                 System.out.println();         
                 console.nextLine();
                 boolean result = playGame(letters, console);
                 if( result)
                    totalWin++;
                 printResult(result, console);     
                 String prompt = "\n\nDo you want to play another game? y/n: ";
                 totalPlay++;
                 if (!yesTo(prompt, console))
                   more = false;      
             }
             System.out.println("\n");
             printStat(totalPlay, totalWin);
             morePlayer = yesTo("Is there any other players? ", console);
          }   
   
   
      
    }
    
   /*This method actually plays the game. This method gets the number of the letters in the
   word. The computer starts guessing different characters by calling the method getGuess. The while loop,
   loops until either, the computer guesses all of the letters, or the computer runs out guesses. After the computer 
   generates a random character, it will ask the user if that letter is in the word or not, 
   if it is, then computer will ask how namy times that letter is repeated in the word.
   The user's answer cannot exceed the number of letters left to be guessed. After each guess made by the computer, the method printGallows
   is called and the parameter for this method is the number of incorrect guesses made by the computer. 
   After exiting the while loop, the method outputs the list of all the letters that were not picked by the computer,
   the list of all the letters that were picked by the computer, and the correct guesses made by the computer. This method return true if the computer was able to
   guess all of the letters in the user's word*/ 
    
    public static boolean playGame(int letters, Scanner console)
    { 
        boolean result = false;
        String guessed = "";
        int correct = 0;
        int word = letters;
        int incorrect = 0;
        int numLeft = letters - correct;
        List<String> lettersInYourWord = new ArrayList<String>(); 
        printGallows(incorrect);
         
        
        while (correct < letters && incorrect < MAX_INCORRECT_GUESSES)
        {
              String letterGuessed = getGuess(guessed);
              System.out.println("I guess the letter " + letterGuessed);
              guessed = guessed + letterGuessed;      
              if (yesTo("Is that letter in the word? ", console)) 
              {
                 lettersInYourWord.add(letterGuessed);
                 System.out.print("How many times is that letter in your word? ");
                 int amount = 0;
                 while (!console.hasNextInt()) 
                  {
                        System.out.println("That's not a number!");
                        System.out.println("Please enter a valid number greater than 0, and less than or equal to " + numLeft + ": ");
                        console.next(); 
                  }
                    
               
                 amount = console.nextInt();               
                 while(amount > numLeft || amount <= 0)
                 {
                   System.out.println("Does not compute!");
                   System.out.println("Please enter a valid number greater than 0, and less than or equal to " + numLeft + ": ");
                   amount = console.nextInt();
                   
                 }
                 if(amount <= numLeft && amount > 0)
                 {
                     correct = correct + amount;
                     printGallows(incorrect);
                 }
                 
                 if(correct > letters)
                 {
                    correct = word;
                 }
                
                 System.out.println("I've got " + correct + " of the " + letters + " letters!");
             } 
             else 
             {
               incorrect++;
               printGallows(incorrect);
             }
            
        }
   
        System.out.println("Remaining letters not guessed by the computer: " + printNotGuessedLetters(guessed));
        System.out.print("Letters Guessed by the computer: ");
        printGuessedLetters(guessed);
        System.out.print("Correctly guessed letters: ");
        System.out.print(lettersInYourWord);
        System.out.println();
            
        return correct == letters;
        
     }
 
 /* Draws a hangman figure with appropriate body parts for the number
    of incorrect guesses(between 0-6), adding a head, torso, legs, and arms. This method accepts the parameter 'guesses',
    indicating the number of  wrong guesses */
    
    public static void printGallows(int guesses)
    {
      System.out.println("+--+");
      System.out.println("|  |");
      if(guesses == 0)
      {
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
      }
       else if(guesses == 1)
      {
         System.out.println("|  o");
         System.out.println("|");
         System.out.println("|");
      }
       else if(guesses == 2)
      {
         System.out.println("|  o");
         System.out.println("|  |");
         System.out.println("|");
      }
       else if(guesses == 3)
      {
         System.out.println("|  o");
         System.out.println("|  |");
         System.out.println("|   \\");
      }
       else if(guesses == 3)
      {
         System.out.println("|  o");
         System.out.println("|  |");
         System.out.println("| /  \\");
      }
       else if(guesses == 4)
      {
         System.out.println("|  o");
         System.out.println("|  |");
         System.out.println("| / \\");
      }
       else if(guesses == 5)
      {
         System.out.println("|  o");
         System.out.println("|  |\\");
         System.out.println("| / \\");
      }
       else if(guesses == 6)
      {
         System.out.println("|  o");
         System.out.println("| /|\\");
         System.out.println("| / \\");
      }
      System.out.println("|");
      System.out.println("+-----");
    
    }
    
    
 /*This method outputs the letters that were selected by the computer. 
 This method recieves the paramter guesses which contains the letters selected by the computer*/ 
    
    public static void printGuessedLetters(String guesses)
    {
        System.out.println(guesses);
    } 
    
    
    
 /* Asks the user a yes/no question, returns true if yes, false if no. This method makes sure to validate
 user input incase something other than 'y' or 'n' is entered.*/

    public static boolean yesTo(String prompt, Scanner console)
    {
      System.out.print(prompt);
      String response = console.next();
      while(!(response.equals("y") || response.equals("n")))
      {
         System.out.println("Does not compute! Please enter either y or n");
         System.out.print(prompt);
         response = console.next();
      }
      if(response.equals("y"))
      {
         return true; 
      }
      else if(response.equals("n"))
      {
         return false;            
      }
      return false;           
    }
    
    
   /*This method chooses a letter at random and validates it, making sure that the random letter
   has'nt been guessed yet. This method accepts the string containing all of the guessed letters so far. */
     
    public static String getGuess(String guesses)
     {
        String guess = " ";
        Random r  = new Random();
        String[] guessesA = guesses.split("(?!^)");
        char randomGuess = (char) (r.nextInt(26) + 'A');
        guess = String.valueOf(randomGuess);
        for (int i = 0; i < guesses.length(); i++) 
        {
            
            boolean length = guessesA[i].contains(String.valueOf(randomGuess));
            while(guessesA[i].contains(String.valueOf(randomGuess)))
            {
               randomGuess = (char) (r.nextInt(26) + 'A');  
               i = 0;
              
            }
            
               guess = String.valueOf(randomGuess);

        }
         return guess;  
    } 
    
    
 /*This method gets the length of the word from the user.
   This method must keep asking the user until the user enters a valid input.
   The length of the word cannot exceed the constant MAX_LENGTH*/
    
    public static int getLengthWord(Scanner kb)
    {
       int length = 0;
       do 
       {
           System.out.println("How many letters are in your word, you must choose a number between 1 and 8 ? ");
           while (!kb.hasNextInt())
           {
               System.out.println("That's not a number! Please enter a number between 1 and 8.");
               kb.next(); 
           }
           length = kb.nextInt();
       } while (length <= 0 || length > MAX_LENGTH);
    System.out.println("Your word's length is " + length);

         return length;
    } 
    
    
    //This method prints messages on the screen, depending on if the computer won or lost.
      
     public static void printResult(boolean result,  Scanner console)
     {
         
         if (result)
         {
            System.out.println("I guessed your word correctly! Good game!");
            System.out.print("Now tell me your word : ");           
         }    
         else
         {
           System.out.println("I maxed out the number of guesses, no more chances for me");
           System.out.println("I lost, your word was too hard");
           System.out.print("Now tell me your word : ");
         }
         System.out.print(console.next());
     }
     
    /*This method prints how many different games the user played and how many times the computer won and how many
    times the computer lost*/ 
    public static void printStat(int totalPlay, int totalWin) 
    {    
             System.out.println("                       RESULT");
             System.out.println("_______________________________________________________");
             System.out.println(" ");
             System.out.println("     Played             Lost             Won ");
             System.out.println("          " + totalPlay + "               "+ (totalPlay - totalWin) + "               " + totalWin);
    }


    
    
     /*This methods  gets one string representing all the letters guessed by the computer. and outputs all the letters 
    that wer not picked by the computer.*/
    public static String printNotGuessedLetters(String guesses)
    {
      String remaind="";
      char[] guessesA = guesses.toCharArray();
      Arrays.sort(guessesA);
      String alphabet = LETTERS;
      char[] alphabetA = alphabet.toCharArray();
      for (int i = 0; i < guesses.length(); i++) 
        {
            for(int j = 0; j < alphabet.length(); j++)
            {
            
               if(guessesA[i] == alphabetA[j])
               {
                  alphabetA[j] = '_';
                  remaind= new String(alphabetA);
               }
                
            } 
        
        }
        return remaind;
     }
     
    
 // explains the program to the user.
 
    public static void giveIntro()
    {
      System.out.println("************************************************************************");
      System.out.println("This program plays a game of reverse hangman.");
      System.out.println("You think up a word and I will try to guess the letters.");
      System.out.println("The maximum number of incorrect guesses for me is : 6");
      System.out.println("The maximum number of the letters in your word is : 8");
      System.out.println("+--+");
      System.out.println("|  |");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("+-----");
      System.out.println("************************************************************************");

    }
    
    
    
}

