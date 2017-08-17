package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Daemon implements Runnable {
    private Thread[] threads = new Thread[10];
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println("DaemonSpawn: " + i + " started, ");
        }
        for (int i = 0; i < threads.length; i++) {
            System.out.println("threads[" + i + "] isDaemon(): " + threads[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}
class DaemonSpawn implements Runnable {
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread daemon = new Thread(new Daemon());
        daemon.setDaemon(true);
        daemon.start();
        System.out.println("daemon.isDaemon(): " + daemon.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
