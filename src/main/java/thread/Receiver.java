package thread;

import java.io.IOException;
import java.io.PipedReader;
import java.util.concurrent.*;

/**
 * @author vons0
 */
public class Receiver implements Runnable {

    private PipedReader reader;

    public Receiver(Sender sender) throws IOException {
        reader = new PipedReader(sender.getWriter());
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.printf("Read:%s\n", (char) reader.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        Sender sender = new Sender();
//        Receiver receiver = new Receiver(sender);
//        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), new NamedFactory("vons", false));
//        executorService.execute(sender);
//        executorService.execute(receiver);
//        TimeUnit.SECONDS.sleep(4);
//        executorService.shutdownNow();

        //指定任务的执行时间
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10, new NamedFactory("von", false));
        scheduledExecutorService.schedule(() -> System.out.println("scheduledExecutorService"), 5000, TimeUnit.MILLISECONDS);

    }
}
