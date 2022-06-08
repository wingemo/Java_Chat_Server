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
		// It takes some time to consume a task.
		try {
			Thread.sleep(random.nextInt(1000));
		}
		catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
