import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TextServer {
  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6013);

      while (true) {
        Socket client = sock.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String clientMessage = in.readLine();
        System.out.println("Received from client: " + clientMessage);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message to send to the client: ");
        String userInput = scanner.nextLine();
        PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
        pout.println(userInput);
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);

    }
  }
}
