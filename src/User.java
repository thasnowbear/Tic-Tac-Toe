/**
 * Created with IntelliJ IDEA.
 * User: Notandi
 * Date: 12.11.2012
 * Time: 17:02
 */
public class User {
    private String name;
    private int wins;
    private char sign;

    public int getWin() {
        return wins;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public User(String name, char sign) {
        this.name = name;
        this.sign = sign;
        wins = 0;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addWin() {
        wins++;
    }
}
