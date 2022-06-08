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

    public void setServer(Server server) {
        this.server = server;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public void run() {

    }
}

