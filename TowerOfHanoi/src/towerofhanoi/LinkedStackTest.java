// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Test class for LinkedStack to check functionality
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> stack1;

    private LinkedStack<String> emptyStack;

    /**
     * Set ups variables to be tested
     */
    public void setUp() {
        stack1 = new LinkedStack<String>();
        stack1.push("test1");
        stack1.push("test2");

        emptyStack = new LinkedStack<String>();


    }


    /**
     * Tests size() method
     */
    public void testSize() {
        assertEquals(2, stack1.size());
        assertEquals(0, emptyStack.size());
    }


    /**
     * Tests isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(emptyStack.isEmpty());
        assertFalse(stack1.isEmpty());
    }


    /**
     * Tests peek() method
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            emptyStack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

        assertEquals("test2", stack1.peek());
    }


    /**
     * Tests push() method
     */
    public void testPush() {
        stack1.push("test3");
        assertEquals("test3", stack1.peek());
        assertEquals(3, stack1.size());
    }


    /**
     * Tests pop() method
     */
    public void testPop() {
        assertEquals("test2", stack1.pop());
        assertEquals(1, stack1.size());
    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        assertEquals("[test2, test1]", stack1.toString());
        stack1.push("test3");
        assertEquals("[test3, test2, test1]", stack1.toString());
        assertEquals("[]", emptyStack.toString());
    }


    /**
     * Tests clear() method
     */
    public void testClear() {
        stack1.clear();
        assertTrue(stack1.isEmpty());
        assertEquals(0, stack1.size());

    }


}
