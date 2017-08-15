package example;

import java.util.concurrent.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Fibonacci_4 implements Runnable {
    private int count = 10;
    public Fibonacci_4(int count) {
        this.count = count;
    }
    private int fib(int count) {
        if ((count > 2) || (count == 2)) {
            return fib(count - 2) + fib(count -1);
        } else {
            return 1;
        }
    }
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
        Thread.yield();
    }
}
public class Example_4 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec2 = Executors.newFixedThreadPool(2);
        ExecutorService exec3 = Executors.newSingleThreadExecutor();
        exec.execute(new Fibonacci_4(10));
        exec.shutdown();
        exec2.execute(new Fibonacci_4(15));
        exec2.shutdown();
        exec3.execute(new Fibonacci_4(20));
        exec3.shutdown();
    }
}
