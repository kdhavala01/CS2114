// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import student.TestCase;

/**
 * Test class to check if the methods in Disk work
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class DiskTest extends TestCase {
    private Disk disk;
    private Disk equalDisk;
    private Disk largerDisk;
    private Disk nullDisk;
    private Disk smallerDisk;

    /**
     * Setups up variables to be tested
     */
    public void setUp() {
        disk = new Disk(5);
        equalDisk = new Disk(5);
        largerDisk = new Disk(8);
        nullDisk = null;
        smallerDisk = new Disk(3);

    }


    /**
     * Tests compareTo() method
     */
    public void testCompareTo() {
        Exception thrown = null;
        try {
            disk.compareTo(nullDisk);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);

        assertEquals(-1, disk.compareTo(largerDisk));
        assertEquals(1, disk.compareTo(smallerDisk));
        assertEquals(0, disk.compareTo(equalDisk));

    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        assertEquals("5", disk.toString());
    }


    /**
     * Tests equals() method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertTrue(disk.equals(disk));
        assertTrue(disk.equals(equalDisk));
        assertFalse(disk.equals(largerDisk));
        assertFalse(disk.equals(nullDisk));
        assertFalse(disk.equals(""));
    }

}
