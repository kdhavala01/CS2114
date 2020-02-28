// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Krishna Dhavala (kdhavala)

package game;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This class implements the GUI to create visual aid for both bag
 * implementations
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.02.24
 */
public class WhackAShape {
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;

    /**
     * This class is the constructor for this class
     * 
     * It initializes the window and buttons and adds shapes to the bag to
     * display using the helper method buildShape
     * 
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        window.setSize(400, 400);
        window.setTitle("Project 2");
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        randomGenerator = new TestableRandom();
        TestableRandom num = new TestableRandom();
        String[] shapes = { "red circle", "blue circle", "red square",
            "blue square" };
        int range = num.nextInt(5 + 1) + 7;
        for (int i = 0; i < range; i++) {
            int itemNum = num.nextInt(4);
            bag.add(buildShape(shapes[itemNum]));
        }
        window.addShape(bag.pick());

    }


    /**
     * This class is the constructor for this class
     * 
     * It initializes the window and buttons and adds shapes created from the
     * parameter inputs to the bag to display using the helper method buildShape
     * 
     * @param inputs
     *            a string array to be converted to shapes
     * 
     * 
     */
    public WhackAShape(String[] inputs) {
        randomGenerator = new TestableRandom();
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        window.setSize(400, 400);

        window.setTitle("Project 2");
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        for (int i = 0; i < inputs.length; i++) {
            try {
                Shape inputShape = buildShape(inputs[i]);
                bag.add(inputShape);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        Shape sh = bag.pick();
        window.addShape(sh);

    }


    /**
     * Class for returning window
     * 
     * @return
     *         the window
     */
    public Window getWindow() {
        return window;
    }


    /**
     * Class for returning the bag
     * 
     * @return
     *         the bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }


    /**
     * Class initializing the clickedShape method
     * 
     * @param shape
     *            the shape to be modified
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape textShape = new TextShape(0, 0, "You Win");
            int xPos = (window.getGraphPanelWidth() - textShape.getWidth()) / 2;
            int yPos = (window.getGraphPanelHeight() / 2) - textShape
                .getHeight();
            textShape.setX(xPos);
            textShape.setY(yPos);
            window.addShape(textShape);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * Class initializing the quit button
     * 
     * @param button
     *            the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Class initializing the buildShape helper method that creates a shape
     * based on a parsed string
     * 
     * @param anEntry
     *            the string to be converted into a shape based on color and
     *            shape
     */
    private Shape buildShape(String anEntry) {
        int x = (window.getGraphPanelWidth()) - (randomGenerator.nextInt(100
            + 1) + 100);
        int y = (window.getGraphPanelHeight()) - (randomGenerator.nextInt(100
            + 1) + 100);

        Shape currentShape;

        if (anEntry.contains("circle") && anEntry.contains("red")) {
            Color color = Color.RED;
            currentShape = new CircleShape(x, y, color);
        }
        else if (anEntry.contains("circle") && anEntry.contains("blue")) {
            Color color = Color.BLUE;
            currentShape = new CircleShape(x, y, color);
        }
        else if (anEntry.contains("square") && anEntry.contains("red")) {
            Color color = Color.RED;
            currentShape = new SquareShape(x, y, color);
        }
        else if (anEntry.contains("square") && anEntry.contains("blue")) {
            Color color = Color.BLUE;
            currentShape = new SquareShape(x, y, color);
        }
        else {
            throw new IllegalArgumentException();
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;

    }

}
