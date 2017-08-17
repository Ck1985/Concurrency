package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class ADaemon implements Runnable {
    public void run() {
        try {
            System.out.println("ADaemon is started");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println("Existting via Interrupt");
        } finally {
            System.out.println("This should always run ");
        }
    }
}
public class DaemonDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new ADaemon());
        //thread.setDaemon(true);
        thread.start();
    }
}
