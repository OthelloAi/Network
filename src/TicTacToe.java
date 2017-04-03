import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TicTacToe {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner scan;

    TicTacToe(String loginName, String gameName) throws IOException {
        openSocket();
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        login(loginName);
        subscribeToGame(gameName);
    }

    TicTacToe() throws IOException {
        openSocket();
        System.out.println(in.readLine());
        System.out.println(in.readLine());
    }

    public void openSocket() {

        try {
            socket = new Socket("127.0.0.1", 7789);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            return;
        }
    }

    public void closeSocket() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
    public void makeMove(int pos) throws IOException{
        // if (readLine().contains("YOURTURN"))
        out.println("move " + pos);
    }

    public void login(String loginName) throws IOException {
        out.println("login " + loginName);
        if (readLine().equals("OK")) {
            System.out.println("Login Succesful");
        }

    }

    public String readLine() throws IOException {
        // @todo learn command pattern
        //System.out.println(in.readLine());
        return in.readLine();
    }

    public boolean isMyTurn() throws IOException {
        String temp = readLine();
        if (temp.contains("GAME MOVE")) {
            System.out.println(temp);
            System.out.println(temp.substring(temp.indexOf("MOVE: ")+7, );
        }
        if (temp.contains("YOURTURN")) {
            return true;
        }
        return false;
    }

    public void subscribeToGame(String gameName) throws IOException {
        out.println("subscribe " + gameName);
        if (readLine().equals("OK")) {
            System.out.println("Subscribed to: " + gameName);
        }
    }
}
