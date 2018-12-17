package thread;

import java.util.concurrent.*;

/**
 * @author vons0
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 3000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(), new NamedFactory("测试", false));
        for (int i = 0; i < 10; i++) {
            Future<Long> submit = executorService.submit(new TaskWithResult1(45));
            try {
                Long integer = submit.get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
