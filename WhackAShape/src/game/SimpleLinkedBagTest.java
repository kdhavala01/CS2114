// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package game;

import student.TestCase;
import student.TestableRandom;

/**
 * This is the test class for SimpleLinkedBag to check if all the methods work
 * properly
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.24
 *
 */
public class SimpleLinkedBagTest extends TestCase {
    private SimpleLinkedBag<String> bag1;
    private SimpleLinkedBag<String> bag2;

    /**
     * This method sets up variables to be tested
     */
    public void setUp() {
        bag1 = new SimpleLinkedBag<String>();
        bag1.add("test1");
        bag1.add("test2");

        bag2 = new SimpleLinkedBag<String>();

    }


    /**
     * Tests the getCurrentSize() method
     */
    public void testGetCurrentSize() {
        // Checks if bag size is correct
        assertEquals(2, bag1.getCurrentSize());
        // Checks if bag size is being updated
        bag1.add("blue square");
        assertEquals(3, bag1.getCurrentSize());
    }


    /**
     * Tests the add() method
     */
    public void testAdd() {
        // Tests to see if bag adds objects
        assertTrue(bag1.add("test3"));
        // Tests to see if bag adds null objects which it should not
        bag1.add(null);
        assertFalse(bag1.add(null));
        // Test to see if bag size increased
        assertEquals(3, bag1.getCurrentSize(), 0.01);

    }


    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        // Testing on non empty bag
        assertFalse(bag1.isEmpty());

        // Testing on empty bag
        assertTrue(bag2.isEmpty());

    }


    /**
     * Tests the pick() method
     */
    public void testPick() {
        // Making sure null objects are not picked
        assertEquals(null, bag2.pick());

        // Adding items to make bag1 larger for testing
        bag1.add("test3");
        bag1.add("test4");
        bag1.add("test5");
        bag1.add("test6");
        bag1.add("test7");
        bag1.add("test8");

        // Setting the random integers to fixed numbers to ensure accurate
        // testing
        TestableRandom.setNextInts(0, 2, 7);

        // Checking if bag1 picks correctly
        assertEquals("test8", bag1.pick());
        assertEquals("test6", bag1.pick());
        assertEquals("test1", bag1.pick());

    }


    /**
     * Tests the remove() method
     */
    public void testRemove() {
        // Extend bag contents
        bag1.add("test3");
        bag1.add("test4");

        // Testing if item is remove from bag
        assertTrue(bag1.remove("test2"));
        assertEquals(3, bag1.getCurrentSize());

        // Testing to make sure items not in the bag are not removed
        assertFalse(bag1.remove("test5"));
        assertEquals(3, bag1.getCurrentSize());

    }

}
