// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package project1;

/**
 * This class works as the runner for the whole project
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.12
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
     * Main method to create instances of DisplayCollection and ShapeWindow and
     * run the whole program
     * 
     * @param args
     *            variable added as due to programming convention
     */

    public static void main(String[] args) {
        DisplayCollection dc = new DisplayCollection();
        @SuppressWarnings("unused")
        ShapeWindow sw = new ShapeWindow(dc.getItemBag());
    }

}
