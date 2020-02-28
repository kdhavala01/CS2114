// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package project1;

import bag.Bag;
import bag.BagInterface;
import java.util.Random;

/**
 * This class DisplayCollection will display the bag collection to the GUI
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.12
 */
public class DisplayCollection {
    /**
     * Constant field that contains elements that are to be added to the bag
     * Variable cannot be changed
     */
    public static final String[] STRINGS = { "red circle", "blue circle",
        "red square", "blue square" };
    private BagInterface<String> itemBag;

    /**
     * Constructor of the DisplayCollection class
     * Adds random items from the STRINGS variable to the bag and also
     * determines size of bag
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        Random random = new Random();
        int range = random.nextInt(10 + 1) + 5;
        for (int i = 0; i < range; i++) {
            int itemNum = random.nextInt(4);
            itemBag.add(STRINGS[itemNum]);
        }
    }


    /**
     * Method to get the items in the bag
     * 
     * @return itemBag
     *         all items in the bag returned
     */
    public BagInterface<String> getItemBag() {
        return itemBag;

    }

}
