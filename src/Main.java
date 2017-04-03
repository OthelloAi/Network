import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String loginName;
        String gameName;

        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Type your login name:");
        loginName = scanner.next();
        game.login(loginName);

        System.out.println("Type the game you want to play:");
        gameName = scanner.next();
        game.subscribeToGame(gameName);

        System.out.println("Waiting for game to start...");
        //TicTacToe game = new TicTacToe("Gabe", "Tic-tac-toe");

        while(1 == 1) {
            if (game.isMyTurn()) {
                int input;
                System.out.println("Your turn:");
                System.out.println("Pick a position");
                input = scanner.nextInt();
                game.makeMove(input);
            }
        }

    }
}