/**
 * Created with IntelliJ IDEA.
 * User: Notandi
 * Date: 12.11.2012
 * Time: 17:02
 */
public class Board {
    char[] boardArray = new char[9];

    public Board() {
        for (int i = 0; i < 9; i++) {
            boardArray[i] = Character.forDigit(i + 1, 10);
        }
    }

    public String toString() {
        return ("s");
    }

    public boolean updateBoard(char c, int move) {
        if (boardArray[move] == 'X' || boardArray[move] == 'O')
            return false;
        else
            boardArray[move] = c;
        return true;
    }

    public char checkWinner() {
        return 'x';
    }

}
