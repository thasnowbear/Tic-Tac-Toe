import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: Lund
 * Date: 14.11.12
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class GameTest extends TestCase {
    public GameTest() {

    }

    public void testSetPlayers() throws Exception {
        Game g = new Game();
        assertEquals("Testing if signs for player 1", 'x', g.player1.getSign());
        assertEquals("Testing if signs for player 2", 'o', g.player2.getSign());
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(GameTest.class);
    }
}
