import java.net.SocketAddress;
import java.util.concurrent.BlockingQueue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Represents a broadcaster handles message
 *
 * @author Philip Wingemo
 * @version 1.0
 * @since   2022-06-31 
 */
class Broadcaster implements Runnable {

  private BlockingQueue < String > broadcastQueue;
  private ConcurrentHashMap < SocketAddress, Client > clientMap;

  public Broadcaster(ConcurrentHashMap < SocketAddress, Client > clientMap, BlockingQueue < String > queue) {
    this.broadcastQueue = queue;
    this.clientMap = clientMap;
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
