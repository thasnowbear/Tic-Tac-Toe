package is.metro;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 11/23/12
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class UITest extends TestCase {
    public UITest(){
    }

    public void testToString() {
        Board b = new Board();
        UI ui = new UI();
        char boardArray[][] = b.getBoardArray();
        String display = "   " + boardArray[0][0] + "  |  " + boardArray[1][0] + "  |  " + boardArray[2][0] + "\n";
        display += " -----+-----+-----" + "\n";
        display += "   " + boardArray[0][1] + "  |  " + boardArray[1][1] + "  |  " + boardArray[2][1] + "\n"
                + " -----+-----+-----" + "\n"
                + "   " + boardArray[0][2] + "  |  " + boardArray[1][2] + "  |  " + boardArray[2][2] + "\n";

        assertEquals("Test whole board", display, ui.toString(boardArray));
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(UITest.class);
    }
}