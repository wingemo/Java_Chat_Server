import java.io.IOException;

/**
* Thread safe stream socket chat server
*
* @author  Philip Wingemo
* @version 1.0
* @since   2022-06-31 
*/
public class Main {
  private static Server server;
  private static int threads;

  public static void main(String[] args) {
    try {
      threads = Runtime.getRuntime().availableProcessors();
      server = new Server(Integer.parseInt(args[0]), threads);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
