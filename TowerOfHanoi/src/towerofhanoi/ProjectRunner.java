// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

/**
 * ProjectRunner class to run the project code
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class ProjectRunner {

    /**
     * Main method to run the code
     * 
     * @param args
     *            input array
     */
    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        new PuzzleWindow(new HanoiSolver(disks));

    }

}
