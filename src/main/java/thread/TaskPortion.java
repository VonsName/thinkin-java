package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author vons0
 */
public class TaskPortion implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private static Random random = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            latch.countDown();
        }

    }

    public void  doWork() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(random.nextInt(2000));
        System.out.println("finish");
    }
}
