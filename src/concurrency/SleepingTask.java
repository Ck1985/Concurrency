package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class SleepingTask extends LiftOff {
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(10000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
