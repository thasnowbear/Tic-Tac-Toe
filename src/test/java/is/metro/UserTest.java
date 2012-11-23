package is.metro;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * is.metro.User: Notandi
 * Date: 14.11.2012
 * Time: 14:57
 */
public class UserTest extends TestCase {
    public UserTest() {
    }

    public void testWithOneWin() throws Exception {
        User user = new User("Eric", 'X');
        user.addWin();
        assertEquals("added one win from 0", 1, user.getWin());
    }

    public void testWithTwoWin() throws Exception {
        User user = new User("Eric", 'X');
        user.addWin();
        user.addWin();
        assertEquals("added two wins from 0", 2, user.getWin());
    }


    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(UserTest.class);

    }
}
