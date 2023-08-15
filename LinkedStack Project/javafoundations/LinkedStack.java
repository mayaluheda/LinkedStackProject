package javafoundations;

import javafoundations.exceptions.*;
import javafoundations.LinkedStack;

/**
 *  LinkedStack.java       Java Foundations
 *
 *  Represents a linked implementation of a stack.
 *  
 *  @author Maya Lu-Heda
 *  @version 10-29-22
 */

public class LinkedStack<T> implements Stack<T>
{
    private int count;
    private LinearNode<T> top;

    /**
     *  Creates an empty stack using the default capacity.
     */
    public LinkedStack()
    {
        count = 0;
        top = null;
        //top =  new LinearNode(); 
    }

    // /**
     // *  Removes the element at the top of this stack and returns a
     // *  reference to it. Throws an EmptyCollectionException if the
     // *  stack contains no elements.
     // * 
     // * @return the element at the top of the stack
     // */
    // public T pop() throws EmptyCollectionException
    // {
        // if (count == 0){
            // throw new EmptyCollectionException ("Pop operation failed. "
                // + "The stack is empty.");
        // }

        // T result = top.getElement();
        // top = top.getNext();
        // count--;

        // return result;
    // }
    
    /**
     *  Removes the element at the top of this stack and returns a
     *  reference to it. Throws an EmptyCollectionException if the
     *  stack contains no elements.
     * 
     * @return the element at the top of the stack
     */
    public T pop() throws EmptyCollectionException
    {
        if (count == 0){
            throw new EmptyCollectionException ("Pop operation failed. "
                + "The stack is empty.");
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    /**
     *  Returns a string representation of this stack.
     * 
     * @return the elements in the stack
     */
    public String toString()
    {
        String result = "<top of stack>\n";
        LinearNode current = top;

        while (current != null)
        {
            result += current.getElement() + "\n";
            current = current.getNext();
        }

        return result + "<bottom of stack>";
    }

    /**
     * adds a new item to the top of the stack
     */
    public void push (T element) { 
        LinearNode n = new LinearNode(element); 
        n.setNext(top); //to the old top
        top = n; //to the new top
        count++;
    }

    /**
     * Retrieves the item that was added most recently 
     * @ returns the top element
     */
    public T peek () throws EmptyCollectionException { 
        if (count == 0){
            throw new EmptyCollectionException("Peek operation failed. Stack is empty.");
        }
        T result = top.getElement();
        return result;
    }

    /**
     * Determines whether empty or not
     * @ return T/F on whether empty
     */
    public boolean isEmpty() { 
        if (count ==0){
            return true;
        }
        return false;
    }

    /** 
     * Calculates how many items are in the stack
     * @ return number items in stack
     */
    public int size() { 
        return count;
    }
}
