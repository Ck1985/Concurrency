package example;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class AtomicTest12 implements Runnable {
    private int i = 0;
    public synchronized int getValue() {
        return this.i;
    }
    public synchronized void evenIncrement() {
        this.i++;
        this.i++;
    }
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}
public class Example_12 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicTest12 at = new AtomicTest12();
        exec.execute(at);
         while (true) {
             int val = at.getValue();
             if (val % 2 != 0) {
                 System.out.println(val);
                 System.exit(0);
             }
         }
    }
}
