// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package project1;

import student.TestCase;
import bag.BagInterface;

/**
 * Test class for DisplayCollection to check if all the methods are running
 * correctly
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.12
 *
 */
public class DisplayCollectionTest extends TestCase {

    /**
     * The setUp method sets up fields testing
     */

    public void setUp() {
        /**
         * Method is empty as there are no fields to be passed through
         */

    }


    /**
     * Method to test the BagContents() method and see if the added contents are
     * valid contents from the STRINGS[] variables
     */
    public void testBagContents() {
        DisplayCollection test = new DisplayCollection();
        BagInterface<String> testBag = test.getItemBag();
        for (int i = 0; i < testBag.getCurrentSize(); i++) {
            String checker = testBag.remove();
            boolean valid = false;
            if (checker == DisplayCollection.STRINGS[0]) {
                valid = true;
            }
            else if (checker == DisplayCollection.STRINGS[1]) {
                valid = true;
            }
            else if (checker == DisplayCollection.STRINGS[2]) {
                valid = true;
            }
            else if (checker == DisplayCollection.STRINGS[3]) {
                valid = true;
            }
            assertTrue(valid);
            testBag.remove();

        }

    }


    /**
     * Method to test BagSize() method to see if the generated bag size is in
     * the valid range
     */
    public void testBagSize() {
        DisplayCollection test = new DisplayCollection();
        BagInterface<String> testBag = test.getItemBag();
        assertTrue(testBag.getCurrentSize() <= 15);
        assertFalse(testBag.getCurrentSize() < 5);
        assertFalse(testBag.getCurrentSize() > 15);

    }

}
