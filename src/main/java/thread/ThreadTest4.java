package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author vons0
 */
public class ThreadTest4 {

    private static final int SIZE = 10;

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(7, 10, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), new NamedFactory("th", false));
        SynchronizedThread synchronizedThread = new SynchronizedThread();
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(synchronizedThread);
        }
        executorService.shutdown();

//        for (int i = 0; i < 10; i++) {
//            new Thread(synchronizedThread).start();
//        }
    }
}
