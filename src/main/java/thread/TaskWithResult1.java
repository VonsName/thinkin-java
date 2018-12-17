package thread;

import java.util.concurrent.Callable;

/**
 * @author vons0
 */
public class TaskWithResult1 implements Callable<Long> {

    private int n;

    public TaskWithResult1(int count) {
        this.n = count;
    }

    @Override
    public Long call() throws Exception {
        System.out.println(Thread.currentThread().toString());
        return cal(n);
    }

    private long cal(int count) {
        if (count == 2) {
            return 1;
        }
        if (count == 1) {
            return 1;
        }
        return cal(count - 2) + cal(count - 1);
    }
}
