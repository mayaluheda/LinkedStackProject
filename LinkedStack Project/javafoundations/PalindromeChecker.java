package javafoundations;
import java.util.Scanner;
/**
 * Used to determine if a word is palindrome
 *
 * @author Maya Lu-Heda
 * @version 10-29-2022
 */

public class PalindromeChecker
{
    // instance variables 
    private LinkedStack <Character> s1;
    private LinkedStack <Character> s2;
    private char v;
    /**
     * Constructor for objects of class PalindromeChecker
     */
    public PalindromeChecker(String inputString)
    {
        // initialise instance variables
        s1 = new LinkedStack<Character>();
        s2 = new LinkedStack<Character>();
        char[] charArray = inputString.toCharArray();
        for(int i=0; i<charArray.length; i++){
            s1.push(charArray[i]); 
        }
    }

    /**
     * predicate method that returns T/F whether a palindrome or not.
     * @ return T/F whether a palindrome or not
     */
    public boolean isPalindrome() 
    {
        while (s1.size()!=1 || s1.size() == 0){
            v = s1.pop();
            while(!s1.isEmpty()){
                s2.push(s1.pop()); 
            }
            if(v!=s2.pop()){
                return false;
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop()); 
            }
        }
        return true;
    }
    
    /**
     * The main method for testing
     * @param args the command-line arguments
     */
        public static void main(String[] args){
        if (args.length > 0) { //inputed when ran
            System.out.println("Command-line arguments:");
            PalindromeChecker pc = new PalindromeChecker(args[0]);
            System.out.println("is "+args[0]+" a palindrome? "+ pc.isPalindrome()); //should be yes
        }
        
        if (args.length == 0){
            System.out.println("Need to provide an input to determine whether a palindrome.");
        }
        // Keyboard input, stop when q is entered
        else {
            System.out.println("Keyboard input:");
            Scanner scan = new Scanner(System.in);
            String word = scan.nextLine();
            //PalindromeChecker pc = new PalindromeChecker(word);
            while(!word.equals("q")){
                PalindromeChecker pc = new PalindromeChecker(word);
                System.out.println("is "+word+" a palindrome? "+ pc.isPalindrome()); 
                word = scan.nextLine();
            }
            scan.close();
        }
    }
}
