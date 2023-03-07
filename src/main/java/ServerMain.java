import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    static String host = "netology.homework";
    static int port = 9000;
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(port)){
            while(true) {
                try(Socket client = server.accept();
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())))
                {
                    System.out.println("Connection accept");

                    out.println("Write your name? ");
                    String name = in.readLine();
                    out.println("Are you child? (yes/no) ");
                    String isChild = in.readLine();
                    if(isChild.equals("yes")) {
                        out.printf("Welcome to the kids area, %s! Let's play!", name);
                    } else {
                        out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
