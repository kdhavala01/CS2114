// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package project1;

import bag.BagInterface;
import CS2114.TextShape;
import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;

/**
 * This is the Shape Window Class
 * 
 * We will build the GUI in this class
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.12
 */

public class ShapeWindow {
    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;

    /**
     * Constructor for the ShapeWindow class. Sets up the GUI to display items
     * in the bag
     * 
     * @param itemBag
     *            this is the bag that contains all the items being added
     */
    public ShapeWindow(BagInterface<String> itemBag) {
        window = new Window();
        window.setTitle("Project 1");
        this.itemBag = itemBag;
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);
        textShape = new TextShape(0, 0, "");
        window.addShape(textShape);

    }


    /**
     * Method to implement the Quit Button
     * 
     * @param quitButton
     *            button object that is modified by this method
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }


    /**
     * Method to implement the Choose Button
     * 
     * @param chooseButton
     *            button object that is modified by this method
     */
    public void clickedChoose(Button chooseButton) {
        textShape.setText(itemBag.remove());
        if (itemBag.remove() == null) {
            textShape.setText("No more items");
        }
        colorText();
        centerText();

    }


    /**
     * Method to change the color of displayed text
     */
    public void colorText() {
        if (textShape.getText().contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (textShape.getText().contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }

    }


    /**
     * Method to change the position of displayed text to the center of the GUI
     */
    public void centerText() {
        int xPos = (window.getGraphPanelWidth() - textShape.getWidth()) / 2;
        int yPos = (window.getGraphPanelHeight() / 2) - textShape.getHeight();
        textShape.setX(xPos);
        textShape.setY(yPos);

    }

}
