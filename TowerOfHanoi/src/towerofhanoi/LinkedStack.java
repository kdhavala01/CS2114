// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * Linked based implementation of StackInterface
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 * @param <T>
 *            generic variable that can be changed
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size;

    /**
     * Constructor instantiates starting Node and size
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Gets size of stack
     * 
     * @return size
     *         size of stack
     */
    public int size() {
        return size;
    }


    /**
     * Checks if stack is empty
     * 
     * @return
     *         returns true if empty
     */
    public boolean isEmpty() {
        return topNode == null;
    }


    /**
     * Checks top most element of stack and returns it
     * 
     * @return
     *         top most element
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return topNode.getData();
        }
    }


    /**
     * Pushes an element to the top of the stack
     * 
     * @param anEntry
     *            the entry to be pushed onto the stack
     */
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }


    /**
     * Removes an element from the top of the stack
     * 
     * @return
     *         returns removed element
     */
    public T pop() {
        T removed = peek();
        topNode = topNode.getNextNode();
        size--;
        return removed;
    }


    /**
     * Converts the stack into a string
     * 
     * @return
     *         converted string
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        Node<T> copy = topNode;
        int item = size;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while (item != 1) {
            str.append(copy.getData().toString());
            str.append(", ");
            copy = copy.getNextNode();
            item--;
        }
        str.append(copy.getData().toString());
        str.append("]");
        return str.toString();
    }


    /**
     * Completely clears all elements in the stack
     */
    public void clear() {
        topNode = null;
        size = 0;
    }

    /**
     * Private internal class to help implement Linked Stack
     * 
     * @author Krishna Dhavala
     *
     * @param <T>
     *            generic variable that can be changed
     */
    @SuppressWarnings("hiding")
    private class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * Constructor instantiating variables
         * 
         * @param data
         *            data of node
         * @param next
         *            next Node
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }


        /**
         * Getter method for data
         * 
         * @return
         *         data of node
         */
        public T getData() {
            return data;
        }


        /**
         * Getter method for next node
         * 
         * @return
         *         next Node
         */
        public Node<T> getNextNode() {
            return next;
        }

    }

}
