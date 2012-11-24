package is.metro;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * is.metro.User: Notandi
 * Date: 12.11.2012
 * Time: 17:03
 */
public class BoardTest extends TestCase {
    public BoardTest() {
    }

    public void testUpdateBoardOneInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        assertEquals("tests UpdateBoard wants true back", true, b.updateBoard(c, 1));
    }

    public void testUpdateBoardTwoInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        assertEquals("tests UpdateBoard wants true back", true, b.updateBoard(c, 1));
        assertEquals("tests UpdateBoard wants false back", false, b.updateBoard(c, 1));
    }

    public void testUpdateBoardTwoDiffInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        char d = 'O';
        assertEquals("tests UpdateBoard wants false back", true, b.updateBoard(d, 1));
        assertEquals("tests UpdateBoard wants true back", false, b.updateBoard(c, 1));
    }

    public void testUpdateBoardOuttaBoundInput() throws Exception {
        Board b = new Board();
        char c = 'X';
        assertEquals("tests UpdateBoard wants true back", false, b.updateBoard(c, 10));
    }

    public void testCheckWinnerIfColumnIsAWinWithX() throws Exception {
        Board b = new Board();
        char c = 'X';
        b.updateBoard(c, 1);
        b.updateBoard(c, 4);
        b.updateBoard(c, 7);
        b.updateBoard(c, 2);
        b.updateBoard(c, 5);
        b.updateBoard(c, 8);
        b.updateBoard(c, 3);
        b.updateBoard(c, 6);
        b.updateBoard(c, 9);

        assertEquals("Test if the leftmost column full of X's is a win with move 1", 'X', b.checkWinner(c, 1));
        assertEquals("Test if the leftmost column full of X's is a win with move 4", 'X', b.checkWinner(c, 4));
        assertEquals("Test if the leftmost column full of X's is a win with move 7", 'X', b.checkWinner(c, 7));
        assertEquals("Test if the middle column full of X's is a win with move 2", 'X', b.checkWinner(c, 2));
        assertEquals("Test if the middle column full of X's is a win with move 5", 'X', b.checkWinner(c, 5));
        assertEquals("Test if the middle column full of X's is a win with move 8", 'X', b.checkWinner(c, 8));
        assertEquals("Test if the rightmost column full of X's is a win with move 3", 'X', b.checkWinner(c, 3));
        assertEquals("Test if the rightmost column full of X's is a win with move 6", 'X', b.checkWinner(c, 6));
        assertEquals("Test if the rightmost column full of X's is a win with move 9", 'X', b.checkWinner(c, 9));
    }

    public void testCheckWinnerIfColumnIsAWinWithO() throws Exception {
        Board b = new Board();
        char c = 'O';
        b.updateBoard(c, 1);
        b.updateBoard(c, 4);
        b.updateBoard(c, 7);

        assertEquals("Test if leftmost column full of O's is a win with move 1", 'O', b.checkWinner(c, 1));
    }

    public void testCheckWinnerIfRowIsAWin() throws Exception {
        Board b = new Board();
        char c = 'X';
        char d = 'O';
        b.updateBoard(c, 1);
        b.updateBoard(c, 2);
        b.updateBoard(c, 3);
        b.updateBoard(d, 4);
        b.updateBoard(d, 5);
        b.updateBoard(d, 6);

        assertEquals("Test if the top row full of X's is a win with move 1", 'X', b.checkWinner(c, 1));
        assertEquals("Test if the top row full of X's is a win with move 2", 'X', b.checkWinner(c, 2));
        assertEquals("Test if the top row full of X's is a win with move 3", 'X', b.checkWinner(c, 3));
        assertEquals("Test if the middle row full of O's is a win with move 4", 'O', b.checkWinner(d, 4));
        assertEquals("Test if the middle row full of O's is a win with move 5", 'O', b.checkWinner(d, 5));
        assertEquals("Test if the middle row full of O's is a win with move 6", 'O', b.checkWinner(d, 6));
    }

    public void testCheckWinnerIfDiagonalIsAWin() throws Exception {
        Board b = new Board();
        char c = 'X';
        b.updateBoard(c, 1);
        b.updateBoard(c, 5);
        b.updateBoard(c, 9);

        assertEquals("Test if a diagonal from top left to bottom right full of X's is a win with move 1", 'X', b.checkWinner(c, 1));
        assertEquals("Test if a diagonal from top left to bottom right full of X's is a win with move 5", 'X', b.checkWinner(c, 5));
        assertEquals("Test if a diagonal from top left to bottom right full of X's is a win with move 9", 'X', b.checkWinner(c, 9));
    }

    public void testCheckWinnerIfAntiDiagonalIsAWin() throws Exception {
        Board b = new Board();
        char c = 'X';
        b.updateBoard(c, 3);
        b.updateBoard(c, 5);
        b.updateBoard(c, 7);

        assertEquals("Test if a diagonal from top left to bottom right full of X's is a win with move 3", 'X', b.checkWinner(c, 3));
        assertEquals("Test if a diagonal from top left to bottom right full of X's is a win with move 5", 'X', b.checkWinner(c, 5));
        assertEquals("Test if a diagonal from top left to bottom right full of X's is a win with move 7", 'X', b.checkWinner(c, 7));
    }

    public void testCheckWinnerForDraw() throws Exception {
        Board b = new Board();

        b.updateBoard('X', 1);
        b.updateBoard('X', 2);
        b.updateBoard('O', 3);
        b.updateBoard('O', 4);
        b.updateBoard('O', 5);
        b.updateBoard('X', 6);
        b.updateBoard('X', 7);
        b.updateBoard('O', 8);
        b.updateBoard('O', 9);

        assertEquals("Test for a draw", 'D', b.checkWinner('X', 1));
    }

    public void testSetXY() throws Exception {
        Board b = new Board();

        int x, y;
        int[] xy;
        xy = b.setXY(1);
        x = xy[0];
        y = xy[1];

        assertEquals("X should be 0 when move is 1", 0, x);
        assertEquals("Y should be 0 when move is 1", 0, y);

        xy = b.setXY(6);
        x = xy[0];
        y = xy[1];

        assertEquals("X should be 2 when move is 6", 2, x);
        assertEquals("Y should be 1 when move is 6", 1, y);

        xy = b.setXY(9);
        x = xy[0];
        y = xy[1];

        assertEquals("X should be 2 when move is 9", 2, x);
        assertEquals("Y should be 2 when move is 9", 2, y);

        xy = b.setXY(8);
        x = xy[0];
        y = xy[1];

        assertEquals("X should be 1 when move is 8", 1, x);
        assertEquals("Y should be 2 when move is 8", 2, y);

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
