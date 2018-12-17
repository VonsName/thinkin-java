package thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vons0
 */
public class NamedFactory implements ThreadFactory {

    private String prefix;
    private boolean daemon;
    private volatile AtomicInteger aio = new AtomicInteger(0);

    public NamedFactory(String prefix, boolean daemon) {
        this.prefix = prefix;
        this.daemon = daemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(prefix + "-" + aio.incrementAndGet());
        //设置优先级
        thread.setPriority(Thread.NORM_PRIORITY);
        //设置线程的异常处理器
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        if (daemon) {
            //设置是否是守护进程
            thread.setDaemon(true);
        }
//        System.out.println(thread.getUncaughtExceptionHandler());
        return thread;
    }
}
