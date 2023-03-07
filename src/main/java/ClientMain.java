import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        String host = ServerMain.host;
        int port = ServerMain.port;
        try(Socket client = new Socket(host, port);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Scanner scanner = new Scanner(System.in))
        {
            String resp = in.readLine();
            System.out.print(resp);
            String name = scanner.next();
            out.println(name);

            resp = in.readLine();
            System.out.print(resp);
            String isChild = scanner.next();
            out.println(isChild);

            resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
