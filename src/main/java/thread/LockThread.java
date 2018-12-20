package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author vons0
 */
public class LockThread implements Runnable {


    private static final int SIZE = 10000;
    private volatile int count = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        for (int i = 0; i < SIZE; i++) {
            lock.lock();
//            boolean b = lock.tryLock();//error
            count++;
//            if (b) {
                lock.unlock();
//            }
        }
        System.out.println(count);
    }
}
