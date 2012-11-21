/**
 * Created with IntelliJ IDEA.
 * User: Notandi
 * Date: 12.11.2012
 * Time: 17:02
 */

public class Board {
    char[][] boardArray = new char[3][3];

    public Board() {
        int s = 0; // used to keep track of the actual number of the quadrants (1 - 9)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                boardArray[i][j] = Character.forDigit(s + 1, 10);
                s++;
            }
        }
    }

    @Override
    public String toString() {
        String display;
        display = "   " + boardArray[0][0] + "  |  " + boardArray[0][1] + "  |  " + boardArray[0][2] + "\n"  //   1  |  2  |  3
                + " -----+-----+-----" + "\n"                                                       // -----+-----+-----
                + "   " + boardArray[1][0] + "  |  " + boardArray[1][1] + "  |  " + boardArray[1][2] + "\n"  //   4  |  5  |  6
                + " -----+-----+-----" + "\n"                                                       // -----+-----+-----
                + "   " + boardArray[2][0] + "  |  " + boardArray[2][1] + "  |  " + boardArray[2][2] + "\n"; //   7  |  8  |  9

        return display;
    }

    public boolean updateBoard(char c, int move) {
        if(move < 1 || move > 9) {  //If the move is not legal
            return false;
        }

        int x, y;
        int[] xy = setXY(move);
        x = xy[0];
        y = xy[1];

        if (boardArray[x][y] == 'X' || boardArray[x][y] == 'O')
            return false;
        else
            boardArray[x][y] = c;
        return true;
    }

    public char checkWinner(char c, int move, int moveCount) {  /*Checks for a winner after the most recent move by first checking the
                                                   column that move is on, then the row, then the two diagonals*/
        int x, y;
        int[] xy = setXY(move);
        x = xy[0];
        y = xy[1];

        //Check if the column is a win
        for(int i = 0; i < 3; i++){
            if(boardArray[i][y] != c )
                break;
            if (i == 2)
                return c;
        }

        //Check if the row is a win
        for(int i = 0; i < 3; i++){
            if(boardArray[x][i] != c)
                break;
            if (i == 2)
                return c;
        }

        //check if diagonal from top left to bottom right is a win
        if (x==y){ //checks to see if we are on a diagonal
            for(int i = 0; i < 3; i++){
                if(boardArray[i][i] != c)
                    break;
                if (i == 2)
                    return c;
            }
        }

        //check if diagonal from top right to bottom left is a win
        for (int i = 0; i < 3; i++){
            if(boardArray[i][2-i] != c)
                break;
            if(i == 2)
                return c;
        }

        //check for a draw
        if(moveCount == 3*3) //It is written like that so 3 can be replaced with n later
            return 'D';

        return '.';
    }

    public int[] setXY(int move) {   //converts the inserted move into x y coordinates.  Ex: 1 is inserted, so the xy coordinate should be (0,0)
        int y, x = 0;
        if (move >= 1 && move  <= 3)       //Determining the x-coordinate
            x = 0;
        else if (move >= 4 && move <= 6)
            x = 1;
        else if (move >= 7 && move <= 9)
            x = 2;

        for (y = 0; y < 3; y++){   //Sets y coordinate
            if (y == (move - 1) % 3) {
                break;
            }
        }

        return new int[] { x, y };
    }
}
