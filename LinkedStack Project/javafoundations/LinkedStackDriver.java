package javafoundations;
import javafoundations.exceptions.*;

/**
 * Used to test the LinkedStack class
 *
 * @author Maya Lu-Heda
 * @version 10-29-22
 */
public class LinkedStackDriver
{
    /**
     * The main method for testing
     */
    public static void main(String[] args){
        LinkedStack <String> l = new LinkedStack<String>();
        try {
            l.pop();
        }
        catch(EmptyCollectionException e) {
              System.out.println("You can't pop on an empty list!");
        }
        l.push("CS230");
        System.out.println("Peek into LinkedStack: "+l.peek()+"\n");
        l.push("is");
        l.push("hard");
        System.out.println("Empty LinkedStack? "+ l.isEmpty()+". Our stack has a size of: "+l.size()+"\n");
        System.out.println("The stack: \n" + l);
       
        System.out.println("\npop-ing from the stack:");
        while (!l.isEmpty()) {
            System.out.println(l.pop());
        }
    }
}
