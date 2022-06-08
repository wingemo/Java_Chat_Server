import java.net.SocketAddress;
import java.util.concurrent.BlockingQueue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

class Broadcaster implements Runnable {

  private BlockingQueue < String > broadcastQueue;
  private ConcurrentHashMap < SocketAddress, ClientHandler > clientMap;

  public Broadcaster(ConcurrentHashMap < SocketAddress, ClientHandler > clientMap, BlockingQueue < String > queue) {
    this.broadcastQueue = queue;
    this.clientMap = clientMap;
  }

  public void run() {
    while (true) {
      try {
        String message = broadcastQueue.take();
        consume(message);
      } catch (Exception exception) {
        System.out.println(exception);
      }
    }
  }

  private void consume(String message) {
    try {
      clientMap.forEach((id, client) -> {
        client.send(messeage);
      });
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
}
