package thread;

/**
 * @author vons0
 */
public class SoutThread implements Runnable {
    @Override
    public void run() {
        System.out.println("执行了：" + Thread.currentThread().getId());
//        Thread.yield();
    }
}
