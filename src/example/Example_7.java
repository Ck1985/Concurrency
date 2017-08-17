package example;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Daemon7 implements Runnable {
    private Thread[] threads = new Thread[10];
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new DaemonSpawn7());
            threads[i].start();
            System.out.println("DaemonSpawn7[" + i + "] is started");
        }
        for (int i = 0; i < threads.length; i++) {
            System.out.println("Thread[" + i + "] isDaemn:" + threads[i].isDaemon());
        }
    }
}
class DaemonSpawn7 implements Runnable {
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
public class Example_7 {
    public static void main(String[] args) throws Exception {
        Thread threadDaemon = new Thread(new Daemon7());
        threadDaemon.setDaemon(true);
        threadDaemon.start();
        TimeUnit.SECONDS.sleep(2);
    }
}
