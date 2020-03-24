// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (kdhavala)

package towerofhanoi;

import student.TestCase;

/**
 * Test class for checking if HanoiSolver is working properly
 * 
 * @author Krishna Dhavala <kdhavala>
 * @version 2020.03.24
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver solver;
    private HanoiSolver solver2;

    /**
     * Sets up variables to be tested
     */
    public void setUp() {
        solver = new HanoiSolver(5);
        solver.getTower(Position.LEFT).push(new Disk(10));
        solver.getTower(Position.MIDDLE).push(new Disk(20));
        solver.getTower(Position.RIGHT).push(new Disk(30));

        solver2 = new HanoiSolver(3);
        solver2.getTower(Position.RIGHT).push(new Disk(30));
        solver2.getTower(Position.RIGHT).push(new Disk(20));
        solver2.getTower(Position.RIGHT).push(new Disk(10));

    }


    /**
     * Tests disk() method
     */
    public void testDisks() {
        assertEquals(5, solver.disks());
    }


    /**
     * Tests getTower() method
     */
    public void testGetTower() {
        assertEquals(1, solver.getTower(Position.LEFT).size());
        assertEquals(1, solver.getTower(Position.DEFAULT).size());

    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        assertEquals("[10][20][30]", solver.toString());
    }


    /**
     * Tests solve() method
     */
    public void testSolve() {
        solver2.solve();
        int top = solver2.getTower(Position.LEFT).pop().getWidth();
        assertEquals(10, top);
        int middle = solver2.getTower(Position.LEFT).pop().getWidth();
        assertEquals(20, middle);
        int bottom = solver2.getTower(Position.LEFT).pop().getWidth();
        assertEquals(30, bottom);

    }

}
