package thread;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author vons0
 */
public class Sender implements Runnable {

    private Random random = new Random(47);
    private PipedWriter writer = new PipedWriter();

    public PipedWriter getWriter() {
        return writer;
    }

    @Override
    public void run() {

        try {
            while (true) {
                for (char i = 'A'; i < 'z'; i++) {
                    writer.write(i);
                    TimeUnit.MICROSECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

        }
    }
}
