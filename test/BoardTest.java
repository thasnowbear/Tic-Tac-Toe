import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: Notandi
 * Date: 12.11.2012
 * Time: 17:03
 */
public class BoardTest extends TestCase {
    public BoardTest() {
    }

    public void testUpdateBoardOneInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        assertEquals("tests UpdateBoard wants true back", true, b.updateBoard(c, 0));
    }

    public void testUpdateBoardTwoInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        assertEquals("tests UpdateBoard wants true back", true, b.updateBoard(c, 0));
        assertEquals("tests UpdateBoard wants false back", false, b.updateBoard(c, 0));
    }

    public void testUpdateBoardTwoDiffInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        char d = 'O';
        assertEquals("tests UpdateBoard wants false back", true, b.updateBoard(d, 0));
        assertEquals("tests UpdateBoard wants true back", false, b.updateBoard(c, 0));
    }

    public void testUpdateBoardOuttaBoundInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        assertEquals("tests UpdateBoard wants true back", false, b.updateBoard(c, 10));
    }

    public void testCheckWinnerNoWinnerAndNothingPlaced() throws Exception {
        Board b = new Board();
        assertEquals("Test for winner when no winner should return .", '.', b.checkWinner());
    }

    public void testCheckWinnerWithWinner0to2() throws Exception {
        Board b = new Board();

        b.updateBoard('X', 0);
        b.updateBoard('X', 1);
        b.updateBoard('X', 2);

        assertEquals("Test for winner when no winner should return X", 'X', b.checkWinner());
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(BoardTest.class);
    }
}
