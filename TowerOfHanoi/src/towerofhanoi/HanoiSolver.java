// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import java.util.Observable;

/**
 * HanoiSolver class aims to solve the back end puzzle of Tower of Hanoi
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Instantiates towers and disk number variables
     * 
     * @param numDisks
     *            number of disks on the tower
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * Outputs number of disks
     * 
     * @return
     *         returns number of disks on towers
     */
    public int disks() {
        return numDisks;
    }


    /**
     * Obtains tower based on inputted position
     * 
     * @param pos
     *            Position of the tower
     * @return
     *         returns Tower at inputted position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    /**
     * Converts the disk widths in all the towers to a string
     * 
     * @return
     *         string of appended disk widths from all towers
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * Method to actually move disk from one tower another
     * 
     * @param source
     *            starting point of disk
     * @param destination
     *            ending point of disk
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Recursive solution of Tower of Hanoi to move disks from one tower to
     * another
     * 
     * @param currentDisks
     *            number of disks on tower
     * @param startPole
     *            starting tower
     * @param tempPole
     *            temporary tower
     * @param endPole
     *            ending tower
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        if (currentDisks > 1) {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);

        }
    }


    /**
     * Inputs the towers for private method solveTowers() for actual solution
     */
    public void solve() {
        solveTowers(this.numDisks, this.right, this.middle, this.left);

    }

}
