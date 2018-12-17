package thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author vons0
 */
public class ThreadTest1 {

    private static final int SIZE=10;

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(), new NamedFactory("测试", false));
        ArrayList<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> stringFuture : list) {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}
