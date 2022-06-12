import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler implements Runnable {

    private Server server;

    private Socket socket;

    private int identifier;

    public ClientHandler(Socket clientSocket) {}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return identifier == that.identifier &&
            Objects.equals(server, that.server) &&
            Objects.equals(socket, that.socket);
    }

    public void clientSend(String message) {
        try {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, identifier);
    }

    /**
     * Run.
     */
    @Override
    public void run() {
        try {
            server.broadcast(ip + ": CONNECTED");
            input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            while ((line = reader.readLine()) != null) {
                server.broadcast(ip + ": " + line);
            }
            closeClient();
        } catch (IOException e) {
            closeClient();
        }
    }
}
