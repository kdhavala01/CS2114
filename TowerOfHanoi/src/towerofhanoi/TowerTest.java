// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import student.TestCase;

/**
 * Test class to check functionality of Tower class
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class TowerTest extends TestCase {
    private Tower towerLeft;
    private Tower towerMiddle;
    private Tower towerRight;
    private Tower towerDefault;
    private Disk nullDisk;
    private Disk largerDisk;
    private Disk smallerDisk;
    private Disk equalDisk;

    /**
     * Sets up all the variables to be tested
     */
    public void setUp() {
        towerLeft = new Tower(Position.LEFT);
        towerRight = new Tower(Position.RIGHT);
        towerMiddle = new Tower(Position.MIDDLE);
        towerDefault = new Tower(Position.DEFAULT);
        nullDisk = null;
        towerLeft.push(new Disk(10));
        largerDisk = new Disk(15);
        smallerDisk = new Disk(5);
        equalDisk = new Disk(10);

    }


    /**
     * Tests position() method
     */
    public void testPosition() {
        assertEquals(Position.LEFT, towerLeft.position());
        assertEquals(Position.RIGHT, towerRight.position());
        assertEquals(Position.MIDDLE, towerMiddle.position());
        assertEquals(Position.DEFAULT, towerDefault.position());

    }


    /**
     * Tests push() method
     */
    public void testPush() {
        Exception thrown = null;
        try {
            towerLeft.push(nullDisk);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);

        Exception thrown2 = null;
        try {
            towerLeft.push(largerDisk);
            towerLeft.push(equalDisk);
        }
        catch (Exception exception2) {
            thrown2 = exception2;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown2);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown2 instanceof IllegalStateException);

        towerLeft.push(smallerDisk);
        assertEquals(2, towerLeft.size());

    }

}
