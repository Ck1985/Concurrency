package example;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Fibonacci5 implements Callable<String> {
    private int count = 10;
    public Fibonacci5(int count) {
        this.count = count;
    }
    private Integer fib(int count) {
        if ((count > 2) || (count == 2)) {
            return fib(count - 1) + fib(count - 2);
        } else {
            return 1;
        }
    }
    private Integer sumFib(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += fib(i);
        }
        return sum;
    }
    public String call() {
        return "Sum fibonacci numbers equals: " + sumFib(this.count);
    }
}
public class Example_5 {
    public static void main(String[] args) {
        Fibonacci5 fib = new Fibonacci5(10);
        Fibonacci5 fib2 = new Fibonacci5(5);
        Fibonacci5 fib3 = new Fibonacci5(6);
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> result = exec.submit(fib);
        try {
            System.out.println("Result: " + result.get());
        } catch (ExecutionException ex) {
            System.out.println(ex);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            exec.shutdown();
        }
    }
}
