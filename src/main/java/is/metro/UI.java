package is.metro;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 11/24/12
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class UI {
    public UI() {
    }

    public String toString(char[][] boardArray) {
        String display = "";
        int n = boardArray.length;

        for(int y = 0; y < n; y++){
            if (y!=0) {
                for (int i = 0; i < n; i++){ //The row in between the numbered rows
                    if (i == 0)
                        display += " -----+";
                    else if (i == n-1)
                        display += "-----" + "\n";
                    else
                        display += "-----+";
                }
            }
            for(int x = 0; x < n; x++){
                if(x == 0) //If the grid is on the leftmost column
                    display +="   " + boardArray[x][y] + "  |";
                else if(x == n-1){ //If the grid is on the rightmost column
                    display +="  " + boardArray[x][y] + "\n";
                }
                else //if the grid is in the middle
                    display +="  " + boardArray[x][y] + "  |";
            }
        }

        return display;
    }
}
