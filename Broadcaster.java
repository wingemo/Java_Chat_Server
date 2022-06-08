import java.util.concurrent.BlockingQueue;
import java.util.Random;

class Consumer implements Runnable {

        private BlockingQueue<String message> broadcastQueue;
        private ConcurrentHashMap <SocketAddress, ClientHandler> clientMap;

	Consumer(BlockingQueue<Task> queue) { 
		this.queue = queue; 
	}
	
	public void run() {
		while (true) {
			try {
				String message = queue.take();
				consume(task);
			}
			catch (Exception exception) {
				System.out.println(exception);
			}
		}
	}
	
	void consume(Task task) {
		try {
			clientMap.forEach((id, client) -> {
                           client.add(messeage);
                        });
		}
		catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
