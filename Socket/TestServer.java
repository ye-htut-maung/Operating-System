import java.io.*;
import java.net.*;
public class TestServer {
  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6013);
      while (true) {
        Socket client = sock.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String clientMessage = in.readLine();
        System.out.println("Received from client: " + clientMessage);

        PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
        pout.println("Server received: " + clientMessage);
        pout.println("server's current date and time: " + new java.util.Date().toString());
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
