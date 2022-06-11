import java.io.IOException;

/**
* Thread safe stream socket chat server
*
* @author  Philip Wingemo
* @version 1.0
* @since   2022-06-31 
*/
public class Main {
  private Server server;
  private int threads;

  public static void main(String[] args) {
    try {
      Main main = new Main();  
      main.threads = Runtime.getRuntime().availableProcessors() - 1;
      main.server = new Server(Integer.parseInt(args[0]), main.threads);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
