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

    public void testCheckWinnerWithWinner3to5() throws Exception {
        Board b = new Board();

        b.updateBoard('X', 3);
        b.updateBoard('X', 4);
        b.updateBoard('X', 5);

        assertEquals("Test for winner when no winner should return X", 'X', b.checkWinner());
    }
    public void testCheckWinnerWithWinner0to2O() throws Exception {
        Board b = new Board();

        b.updateBoard('O', 0);
        b.updateBoard('O', 1);
        b.updateBoard('O', 2);

        assertEquals("Test for winner when no winner should return O", 'O', b.checkWinner());
    }

    public void testCheckWinnerWithWinner3to5O() throws Exception {
        Board b = new Board();

        b.updateBoard('O', 3);
        b.updateBoard('O', 4);
        b.updateBoard('O', 5);

        assertEquals("Test for winner when no winner should return O", 'O', b.checkWinner());
    }

    public void testCheckWinnerWithWinner6to8() throws Exception {
        Board b = new Board();

        b.updateBoard('X', 6);
        b.updateBoard('X', 7);
        b.updateBoard('X', 8);

        assertEquals("Test for winner when no winner should return X", 'X', b.checkWinner());
    }

    public void testCheckWinnerWithNoWinner6to8() throws Exception {
        Board b = new Board();

        b.updateBoard('X', 6);
        b.updateBoard('O', 7);
        b.updateBoard('X', 8);

        assertEquals("Test for winner when no winner should return X", '.', b.checkWinner());
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
