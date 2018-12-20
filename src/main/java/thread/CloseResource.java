package thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author vons0
 */
public class CloseResource {

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream inputStream = new Socket("localhost", 8080).getInputStream();
        executorService.execute(new IoBlocked(inputStream));
        executorService.execute(new IoBlocked(System.in));
        TimeUnit.SECONDS.sleep(1);
        System.out.println("shutdown all threads");
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing"+inputStream.getClass().getName());
        inputStream.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing"+System.in.getClass().getName());
        System.in.close();
    }
}
