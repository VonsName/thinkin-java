package thread;

/**
 * @author vons0
 */
public class SynchronizedThread implements Runnable {

    private static final int SIZE = 10000;
    private volatile int count = 0;

    @Override
    public void run() {
        increment();
    }

    public  void increment() {
        synchronized(this){
            for (int i = 0; i < SIZE; i++) {
//            synchronized (this) {
//                count = count + 1;
//            }
                count++;
            }
        }
        System.out.println(count);
    }
}
