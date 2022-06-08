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
    private static String CLIENT_CONNECTED_MSG = "CLIENT CONNECTED: ";
    private static String CLIENT_DISSCONNECTED_MSG = "CLIENT DISSCONNECTED: ";
    private ConcurrentHashMap <SocketAddress, ClientHandler> clientMap;
    private BlockingQueue<String message> broadcastQueue;
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
        clientMap = new ConcurrentHashMap < SocketAddress, ClientHandler >();
        executor = Executors.newFixedThreadPool(threads);
        this.executor.execute(new Broadcaster(clientMap, broadcastQueue));
    }

    /**
     * Adds client to ConcurrentHashMap
     * @param socket client socket
     */
    private void addClient(Socket socket) {
        this.broadcast(CLIENT_CONNECTED_MSG + socket.getRemoteSocketAddress());
        this.clientMap.put(socket.getRemoteSocketAddress(), new ClientHandler(socket));
    }

    /**
     * Remove client from ConcurrentHashMap
     * @param client client socket
     */
    public void removeClient(ClientHandler client) {
        this.clientMap.remove(client.getSocket().getRemoteSocketAddress());
        this.broadcast(CLIENT_DISSCONNECTED_MSG + client.getSocket().getRemoteSocketAddress());
    }

    public void broadcast(String message) {
        broadcastQueue.put(message);
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.clientSocket = serverSocket.accept();
                this.executor.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
