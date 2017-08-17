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
        for (int i = 0; i < 100000; i++) {
        }
    }
}
public class Example_9 {
    public static void main(String[] args) {

    }
}
