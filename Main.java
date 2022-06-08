import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static String CONFIG_FILE_PATH = "config.properties";
    private static Server server;
    private static int threads;

    public static void main(String[] args) {
        threads = Runtime.getRuntime().availableProcessors() - 1;
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            Properties prop = new Properties();
            prop.load(input);
            server = new Server(Integer.parseInt(prop.getProperty("server.port")), threads);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
