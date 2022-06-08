import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Represents a server listening to a port and handles clients
 */
public class Server implements Runnable {
    private ConcurrentHashMap<SocketAddress, ClientHandler> clientMap;
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
            clientMap = new ConcurrentHashMap<SocketAddress, ClientHandler>();
            executor = Executors.newFixedThreadPool(threads);
    }

    /**
     * Adds client to ConcurrentHashMap
     * @param socket client socket
     */
    private void addClient(Socket socket) {
        this.broadcast("CLIENT CONNECTED: " + socket.getRemoteSocketAddress());
        this.clientMap.put(socket.getRemoteSocketAddress(), new ClientHandler(socket));

    }

    /**
     * Remove client from ConcurrentHashMap
     * @param socket client socket
     */
    public void removeClient(Socket socket) {

    }

    public synchronized void broadcast(String message) {

    }

    @Override
    public void run() {
        try {
            while (true) {
                this.clientSocket = serverSocket.accept();
                this.executor.execute(new ClientHandler(clientSocket));
            }
        }
        catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
