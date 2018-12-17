package thread;

import java.io.IOException;

/**
 * @author vons0
 */
public class ResponseUi extends Thread {

    private static volatile double d = 1;

    public ResponseUi() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponseUi();
        System.in.read();
        System.out.println(d);
    }
}
