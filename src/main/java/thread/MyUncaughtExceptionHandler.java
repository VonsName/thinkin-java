package thread;

/**
 * @author vons0
 * 使用UncaughtExceptionHandler 捕捉线程里面抛出的异常
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Throwable e:" + e);
        System.out.println(e.getMessage());
    }
}
