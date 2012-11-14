/**
 * Created with IntelliJ IDEA.
 * User: Notandi
 * Date: 12.11.2012
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String name;
    private int won;

    public User() {
    }

    public User(String name, int won) {
        this.name = name;

        this.won = won;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }
}
