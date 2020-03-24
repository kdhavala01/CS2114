// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;

/**
 * Disk class to create a disk shape to push onto towers
 * Crates Dimensions for Disks
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class Disk extends Shape {

    /**
     * Constructor for Disk sets random color to Disk shape
     * 
     * @param width
     *            width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        Random rand = new Random();
        int num1 = rand.nextInt(256);
        int num2 = rand.nextInt(256);
        int num3 = rand.nextInt(256);
        Color color = new Color(num1, num2, num3);
        this.setBackgroundColor(color);

    }


    /**
     * Method to compare if a disk is smaller of larger than current disk
     * 
     * @param otherDisk
     *            the disk being compared to current disk
     * @return
     *         If otherDisk is smaller, positive number returned
     *         If otherDisk is larger, negative number returned
     *         If both disks are equal, 0 is returned
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        return 0;
    }


    /**
     * Converts the width of the disk to a string
     * 
     * @return
     *         string conversion of the width of the disk
     */
    public String toString() {
        return Integer.toString(this.getWidth());
    }


    /**
     * Checks if the disk object is equal to an inputted object
     * 
     * @param obj
     *            object to be compared to current disk
     * @return
     *         returns true if equal and false if not
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != Disk.class)) {
            return false;
        }
        Disk other = (Disk)obj;
        return other.getWidth() == this.getWidth();

    }

}
