package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author vons0
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("运行是出现错误");
    }

    public static void main(String[] args) {
        try {
            ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), new NamedFactory("von", false));
            executorService.execute(new ExceptionThread());
        }catch (RuntimeException e){
            //不会执行 主线程无法捕捉到线程抛出的错误,但是可以使用Thread.UncaughtExceptionHandler捕捉
            System.out.println("e.getMessage()"+e.getMessage());
        }
    }
}
