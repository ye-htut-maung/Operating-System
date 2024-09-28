import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TextClient {
  public static void main(String[] args) {
    try {

      while (true) {
        Socket sock = new Socket("127.0.0.1", 6013);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message to send to the server: ");
        String userInput = scanner.nextLine();

        PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
        pout.println(userInput);

        // read from server
        InputStream in = sock.getInputStream();
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = bin.readLine()) != null) {
          System.out.println("Server Response: " + line);
        }
        sock.close();
      }

    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
