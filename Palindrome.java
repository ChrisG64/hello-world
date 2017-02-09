// This class provides method to test if a string is a Palindrome using Stack/Queue ADTs.
//Christopher Gomes
import java.util.Stack;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Palindrome {
    // This is a main method to test checkPalindrome method
    public static void main(String[] args) {
        String inputString = new String("");
        Scanner in = new Scanner(System.in);
        do 
        {
            System.out.print("Please enter a string of characters: ");
            String chars = in.next();
            int Pal = checkPalindrome(chars);
            if(Pal != 0)
            {
              System.out.println("The given string is not a palindrome, since the symbol at position " + Pal);
              System.out.println("from the left is different from the symbol at position " + Pal + " " + "from the right.");
            }
            else
            {
               System.out.println("The given string is a palindrome.");
            }
            System.out.print("Want to examine another string? (y/n): ");
            inputString = in.next();
            
        } while( inputString.equals("y") && inputString.length() == 1 );   
        System.out.print("Bye!"); 
    }
    // This is checkPalindrome method. It checks if an input string is Palindrome or not.
    // It returns 0 if a string is a Palindrome. Otherwise, it returns a position of a character where it finds 
    // a different value.
    // Pre-Condition: string must not be null. 
    // Post-Condition: Return 0 if input string is a Palindrome. Return a positive number indicate the location where
    // a difference found. 
    public static int checkPalindrome(String strValue) {  
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();
  
        // check if string is null. If it is null, return a -1
        if(strValue == null)
        {
            return -1;
        }
            // normalize the string values to lower case, remove spaces
            strValue = strValue.replaceAll("\\W", "");
            strValue = strValue.toLowerCase();

            // store data on stack/queue adts first
            for(int i = 0; i <= strValue.length() - 1; i++)
            {
               stack.push(strValue.charAt(i));
            }
            
            for(int x = 0; x <= strValue.length() - 1; x++)
            {
               queue.add(strValue.charAt(x));
            }
            int indexVal = 1;
            // loop: comparing, retrieving text, terminate loop if stack is emptied or found a difference
            while(stack.empty() != true && queue.peek() != null)
            {
               Object sStore = stack.pop();
               Object qStore = queue.remove();
               if(sStore != qStore)
               {
                  return indexVal;
               }
               else
               {
                   indexVal++;
               }
            }
         indexVal = 0;
                   

        return indexVal;
    }
}