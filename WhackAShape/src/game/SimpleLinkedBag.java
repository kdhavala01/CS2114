// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This class implements the SimpleBagInterface using a Linked Chain based bag
 * 
 * @param <T>
 *            generic variable that can be changed in type at any time
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.24
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * Constructor for SimpleArrayBag
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * Adds a new entry to this bag.
     * 
     * @param anEntry
     *            the entry to be removed.
     * @return
     *         True if the addition is successful, or false if not.
     */
    @Override
    public boolean add(T anEntry) {
        if (anEntry != null) {
            Node<T> newNode = new Node<T>(anEntry, firstNode);
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
        return false;
    }


    /**
     * Gets the current number of entries in this bag.
     * 
     * @return
     *         The integer number of entries currently in the bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Sees whether this bag is empty.
     * 
     * @return
     *         True if the bag is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }


    /**
     * Returns a random entry without removing from the bag.
     * 
     * @return
     *         T object if found, null if not found or bag is empty.
     */
    @Override
    public T pick() {
        TestableRandom generator = new TestableRandom();
        if (isEmpty()) {
            return null;
        }
        else {
            Node<T> randomNode = null;
            int index = generator.nextInt(numberOfEntries);
            randomNode = firstNode;
            for (int i = 1; i <= index; i++) {
                randomNode = randomNode.next();
            }
            return randomNode.data();

        }
    }


    /**
     * Removes one occurrence of a given entry from this bag.
     * 
     * @param anEntry
     *            the entry to be removed.
     * @return
     *         True if the removal was successful, or false if not.
     */
    @Override
    public boolean remove(T anEntry) {
        Node<T> localNode = getReferenceTo(anEntry);
        if (localNode == null) {
            return false;
        }
        else {
            localNode = firstNode;
            firstNode = firstNode.next();
            numberOfEntries--;
            return true;
        }
    }


    /**
     * Helper method for the remove method.
     * 
     * @param anEntry
     *            the Node that a reference must be found for
     * 
     * @return
     *         reference of anEntry in the bag
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        return currentNode;

    }

}
