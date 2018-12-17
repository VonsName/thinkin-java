package thread;

/**
 * @author vons0
 */
public class DaemonFromThread implements Runnable {

    private static final int SIZE = 10;

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(Thread.currentThread().toString() + "<-id->" + Thread.currentThread().getId() + "<-is daemon->" + Thread.currentThread().isDaemon());
            try {
                Thread.yield();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
