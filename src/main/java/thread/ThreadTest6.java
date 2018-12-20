package thread;

/**
 * @author vons0
 */
public class ThreadTest6 {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        //wait notify notifyAll 只能在同步块里面调用
        //否则：IllegalMonitorStateException
//        o.wait();
    }
}
