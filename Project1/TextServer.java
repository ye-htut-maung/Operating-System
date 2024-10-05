import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TextServer {
  public static void main(String[] args) {
    try {
      // Create a sever socket listening on port 6013
      ServerSocket sock = new ServerSocket(6013);

      // Now listening for connections
      while (true) {
        // Accept an incoming connection from a client
        Socket client = sock.accept();

        // Read the message sent by the client
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String clientMessage = in.readLine();
        System.out.println("Received from client: " + clientMessage);

        // Accept input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message to send to the client: ");
        String userInput = scanner.nextLine();
        // Send a response to the client
        PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
        pout.println(userInput);

        // Close the client socket and continue listening for new connections
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);

    }
  }
}
