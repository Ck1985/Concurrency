package example;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class PriorityFromFactory implements Runnable {
    private int countDown = 5;
    private volatile int d;
    public String toString() {
        return Thread.currentThread() + ": " + this.countDown;
    }
    public void run() {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) % (double)i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }
}
public class Example_9 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory());
        for (int i = 0; i < 5; i++) {
            exec.execute(new PriorityFromFactory());
        }
        exec.execute(new PriorityFromFactory());
        exec.shutdown();
    }
}
