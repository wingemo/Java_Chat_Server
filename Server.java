import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Represents a server listening to a port and handles clients
 */
public class Server implements Runnable {
    private ConcurrentHashMap<ClientHandler, String> clientMap;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Executor executor;

    /**
     * Constructs a server with a specified number of threads and port
     * @param port server port number
     * @param threads specified number of threads
     */
    public Server(int port, int threads) throws IOException {
            serverSocket = new ServerSocket(port);
            clientMap = new ConcurrentHashMap<>();
            executor = Executors.newFixedThreadPool(threads);
    }

    /**
     * Adds client to ConcurrentHashMap
     * @param socket client socket
     */
    private void addClient(Socket socket) {

    }

    /**
     * Remove client from ConcurrentHashMap
     * @param socket client socket
     */
    public void removeClient(Socket socket) {

    }

    public synchronized void broadcast() {

    }

    @Override
    public void run() {
        try {
            while (true) {
                clientSocket = serverSocket.accept();
                executor.execute(new ClientHandler(clientSocket));
            }
        }
        catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
