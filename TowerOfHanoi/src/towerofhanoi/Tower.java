// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

/**
 * Class to manipulate the towers
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * Constructor to instantiate position and inherit LinkedStack
     * 
     * @param position
     *            position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Method to return position
     * 
     * @return
     *         position of tower
     */
    public Position position() {
        return position;
    }


    /**
     * Method to override the push method in LinkedStack
     * Pushes disks onto the tower only if the pushed disk is smaller than the
     * current disk
     * 
     * @param disk
     *            disk to be pushed
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if ((this.size() > 0) && (this.peek().compareTo(disk) <= 0)) {
            throw new IllegalStateException();
        }
        super.push(disk);

    }

}
