// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Class to create the main GUI for displaying the puzzle
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;

    /**
     * Gap between the towers
     */
    public final static int WIDTH_FACTOR = 150;
    /**
     * Disk width
     */
    public final static int DISK_GAP = 10;
    /**
     * Disk height
     */
    public final static int DISK_HEIGHT = 10;
    /**
     * Tower height
     */
    private static final int TOWER_HEIGHT = 150;
    /**
     * Tower width
     */
    private static final int TOWER_WIDTH = 5;
    /**
     * Tower x coordinate
     */
    private static final int TOWER_X = 150;
    /**
     * Tower y coordinate
     */
    private static final int TOWER_Y = 100;

    /**
     * Constructor to create tower shapes and add disks
     * 
     * @param game
     *            instance of HanoiSolver class to solve the game
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        Button solve = new Button("Solve");

        left = new Shape(TOWER_X, TOWER_Y, TOWER_WIDTH, TOWER_HEIGHT, new Color(
            193, 154, 107));
        middle = new Shape(TOWER_X + WIDTH_FACTOR, TOWER_Y, TOWER_WIDTH,
            TOWER_HEIGHT, new Color(193, 154, 107));
        right = new Shape(TOWER_X + (2 * WIDTH_FACTOR), TOWER_Y, TOWER_WIDTH,
            TOWER_HEIGHT, new Color(193, 154, 107));

        for (int i = 0; i < game.disks(); i++) {
            game.getTower(Position.RIGHT).push(new Disk(DISK_GAP * (this.game
                .disks() + 1 - i)));
            window.addShape(game.getTower(Position.RIGHT).peek());
            moveDisk(Position.RIGHT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.SOUTH);

    }


    /**
     * Method to pause between Disk movements
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Method to move disks onto the towers
     * 
     * @param position
     *            position of tower
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = this.left;
                break;
            case MIDDLE:
                currentPole = this.middle;
                break;
            case RIGHT:
                currentPole = this.right;
                break;
            default:
                currentPole = this.middle;
                break;
        }
        int size = game.getTower(position).size();
        int x = currentPole.getX();
        int y = currentPole.getY() + currentPole.getHeight() - (size
            * DISK_HEIGHT);

        currentDisk.moveTo(x - ((currentDisk.getWidth() - currentPole
            .getWidth()) / 2), y);

    }


    /**
     * Method that supports the Solve button
     * 
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Updates the notifyObservers() in Hanoi Solver
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass().equals(Position.class)) {
            moveDisk((Position)arg);

        }
        sleep();

    }

}
