package thread;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author vons0
 */
public class IoBlocked implements Runnable {
    private InputStream in;

    public IoBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked io");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("exiting IOBLOCKED.RUN");
    }
}
