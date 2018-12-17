package thread;

import java.util.concurrent.Callable;

/**
 * @author vons0
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of Callable" + id;
    }
}
