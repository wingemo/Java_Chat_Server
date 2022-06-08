import java.io.IOException;

public class Main {
  private static String CONFIG_FILE_PATH = "config.properties";
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
