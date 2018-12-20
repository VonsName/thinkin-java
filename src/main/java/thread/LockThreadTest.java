package thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vons0
 */
public class LockThreadTest {

    private static final int SIZE = 10;

    public static void main(String[] args) {


        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), new NamedFactory("测试", false));
        LockThread lockThread = new LockThread();
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(lockThread);
        }
        executorService.shutdown();

        new Timer().schedule(new TimerTask() {
            private AtomicInteger integer = new AtomicInteger(0);

            @Override
            public void run() {
                integer.incrementAndGet();
            }
        }, 5000);
    }
}
