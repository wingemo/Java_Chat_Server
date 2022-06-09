import java.io.IOException;

/**
* The HelloWorld program implements an application that
* simply displays "Hello World!" to the standard output.
*
* @author  Zara Ali
* @version 1.0
* @since   2014-03-31 
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
