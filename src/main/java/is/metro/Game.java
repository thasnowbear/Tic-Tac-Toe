package is.metro; /**
 * Created with IntelliJ IDEA.
 * is.metro.User: Notandi
 * Date: 12.11.2012
 * Time: 17:02
 */

import java.util.Scanner;

public class Game {

    public User player1;
    public User player2;
    public UI ui;

    public Game() {
        setPlayers();

        ui = new UI();

        loop();
    }

    public void setPlayers() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of player 1:");

        String name;
        name = in.nextLine();
        player1 = new User(name, 'X');


        System.out.println("Enter name of player 2:");
        name = in.nextLine();
        player2 = new User(name, 'O');

        //in.close();
    }


    public void loop() {
        boolean isPlayer1 = true;
        User user;
        Scanner in = new Scanner(System.in);

        while (true) {
            Board board = new Board();

            do {
                user = (isPlayer1) ? player1 : player2;
                int cell;
                boolean valid = true;

                do {
                    System.out.println(ui.toString(board.getBoardArray()));

                    if (!valid){
                        System.out.println("Input not valid!");
                    }
                    System.out.println(user.getName() + " - pick a cell 1-9:");

                    cell = in.nextInt();
                    in.nextLine(); // Whitespace
                    valid = board.updateBoard(user.getSign(), cell);
                } while (!valid);


                isPlayer1 = !isPlayer1;
            } while (board.winner == '.');

            System.out.println(board);
            if(board.winner == 'D') {
                System.out.println("Draw");
            } else {
                System.out.println("Winner: " + user.getName() + " (" + board.winner + ")");

                user.addWin();
            }

            System.out.println("Scores:");
            System.out.println(player1.getName() + ": " + player1.getWin());
            System.out.println(player2.getName() + ": " + player2.getWin());

            // Repeat the game?
            System.out.println("Play again (y/n)? ");
            String YorN = in.nextLine();
            if (!YorN.toLowerCase().startsWith("y"))
                break;
        }

        in.close();
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}
