package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author vons0
 */
public class DualSynch {
    private final Object sync = new Object();
    private Lock lock = new ReentrantLock();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
//        synchronized (sync) {

        for (int i = 0; i < 5; i++) {
            lock.lock();
            System.out.println("g()");
            Thread.yield();
            lock.unlock();
        }

//        }
    }

    public static void main(String[] args) {
        DualSynch dualSynch = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}
