package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DaemonFromFactory implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted sleep()");
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemon thread started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
