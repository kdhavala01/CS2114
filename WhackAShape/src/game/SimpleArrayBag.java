// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This class implements the SimpleBagInterface using an Array based bag
 * 
 * @param <T>
 *            generic variable that can be changed in type at any time
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.24
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {
    private T[] bag;
    /**
     * Immutable variable that signifies max capacity of Array based Bags
     */
    private static final int MAX = 25;
    private int numberOfEntries;

    /**
     * Constructor for SimpleArrayBag
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
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
        if (numberOfEntries >= 25 || anEntry == null) {
            return false;
        }
        else {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
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
            int index = generator.nextInt(numberOfEntries);
            return bag[index];

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
        int checker = getIndexOf(anEntry);
        if (checker == -1) {
            return false;
        }
        else {
            bag[checker] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
    }


    /**
     * Helper method for the remove method.
     * 
     * @param anEntry
     *            the entry that the index needs to be found for
     * 
     * @return
     *         index of anEntry in the bag
     */
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;

    }

}
