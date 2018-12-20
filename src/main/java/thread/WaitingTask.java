package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author vons0
 */
public class WaitingTask implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.wait();
            System.out.println("pass:" + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int size = 100;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(countDownLatch));
        }
        for (int i = 0; i < size; i++) {
            executorService.execute(new TaskPortion(countDownLatch));
        }
        System.out.println("latch all tasks");
        executorService.shutdownNow();

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    }
}
