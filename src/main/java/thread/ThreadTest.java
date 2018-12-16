package thread;

import java.util.concurrent.*;

/**
 * @author vons0
 */
public class ThreadTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new SoutThread()).start();
        }
        Executor executor = new ThreadPoolExecutor(1, 10, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>());
        executor.execute(new SoutThread());

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new SoutThread());

        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();

    }
}
