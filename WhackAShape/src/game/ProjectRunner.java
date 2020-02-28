// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package game;

/**
 * This class works as the runner for the whole project
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.24
 *
 */
public class ProjectRunner {
    /**
     * Constructor of project
     */
    public ProjectRunner() {
        /**
         * This method is empty because there are no fields to be passed through
         * it
         */

    }


    /**
     * Main method to create instances of both WhackAShape constructors and
     * run the whole program
     * 
     * @param args
     *            string input array for creating shapes
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            @SuppressWarnings("unused")
            WhackAShape was = new WhackAShape(args);
        }
        else {
            @SuppressWarnings("unused")
            WhackAShape was = new WhackAShape();
        }
    }

}
