import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TestClient {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner (System.in);
      System.out.println("Enter a message to send to the server: ");
      String userInput = scanner.nextLine();

      Socket sock = new Socket ("127.0.0.1", 6013);

      PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
      pout.println(userInput);

      InputStream in = sock.getInputStream();
      BufferedReader bin = new BufferedReader(new InputStreamReader(in));

      String line;
      while ((line = bin.readLine()) != null) {
        System.out.println("Server Response: " + line);
      }

      sock.close();

    } catch (IOException ioe) {System.err.println(ioe);}
  }
}
