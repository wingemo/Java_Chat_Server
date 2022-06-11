import java.net.Socket;

public class ClientHandler implements Runnable {

    private Server server;

    private Socket socket;

    private int identifier;

    public ClientHandler(Socket clientSocket) {
    }

    public Server getServer() {
        return server;
    }

    public Socket getSocket() {
        return socket;
    }

    public int getIdentifier() {
        return identifier;
    }

    @Override
    public void run() {

    }
}

