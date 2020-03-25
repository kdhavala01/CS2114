package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author <Krishna Dhavala> <kdhavala>
 * @version <2020.03.25>
 */
public class Lab08DequeTest extends TestCase {

    private Lab08Deque<String> deque;

    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp() {
        deque = new Lab08Deque<String>();
    }


    /**
     * Tests addToFront() method
     */
    public void testAddToFront() {
        deque.addToFront("test");
        assertEquals("test", deque.getFront());
        assertEquals(1, deque.size());

        deque.addToFront("test2");
        assertEquals("test2", deque.getFront());
        assertEquals(2, deque.size());

    }


    /**
     * Tests addToBack() method
     */
    public void testAddToBack() {
        deque.addToBack("test");
        assertEquals("test", deque.getBack());
        assertEquals(1, deque.size());

        deque.addToBack("test2");
        assertEquals("test2", deque.getBack());
        assertEquals(2, deque.size());

    }


    /**
     * Tests removeFront() method
     */
    public void testRemoveFront() {
        deque.addToFront("test");
        assertEquals("test", deque.removeFront());

        deque.clear();
        deque.addToFront("test");
        deque.addToFront("test2");
        deque.addToFront("test3");

        assertEquals("test3", deque.removeFront());
        assertEquals(2, deque.size());

    }


    /**
     * Tests removeBack() method
     */
    public void testRemoveBack() {
        deque.addToBack("test");
        assertEquals("test", deque.removeBack());

        deque.clear();
        deque.addToBack("test");
        deque.addToBack("test2");
        deque.addToBack("test3");

        assertEquals("test3", deque.removeBack());
        assertEquals(2, deque.size());

    }


    /**
     * Tests getFront() method
     */
    public void testGetFront() {
        Exception thrown = null;
        try {
            deque.getFront();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyQueueException);

        deque.addToFront("test");
        assertEquals("test", deque.getFront());
    }


    /**
     * Tests getBack() method
     */
    public void testGetBack() {
        Exception thrown = null;
        try {
            deque.getBack();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyQueueException);

        deque.addToBack("test");
        assertEquals("test", deque.getBack());
    }


    /**
     * Tests isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.addToBack("test");
        assertFalse(deque.isEmpty());
    }


    /**
     * Tests clear() method
     */
    public void testClear() {
        deque.addToFront("test");
        deque.addToBack("test2");
        deque.addToFront("test3");

        deque.clear();

        assertEquals(0, deque.size());

    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        deque.addToFront("test");
        deque.addToBack("test2");
        deque.addToFront("test3");
        assertEquals("[test3, test, test2]", deque.toString());
    }

}
