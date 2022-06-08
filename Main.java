import java.io.IOException;

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
