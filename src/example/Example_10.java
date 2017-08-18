package example;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Fibonacci_10 implements Callable<String> {
    private int count = 10;
    private String name;
    ExecutorService exec = Executors.newSingleThreadExecutor();
    public Fibonacci_10(String name, int count) {
        this.name = name;
        this.count = count;
    }
    public String call() {
        return "Sum Fibonacci equals: " + sumFib(this.count);
    }
    private Integer fib(int count) {
        if ((count > 2) || (count == 2)) {
            return (fib(count - 2) + fib(count - 1));
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
    public Future<String> runTask(int count) {
        this.count = count;
        Future<String> result = exec.submit(this);
        return result;
    }
}
public class Example_10 {
    public static void main(String[] args) {
        Fibonacci_10 fibonacci = new Fibonacci_10("Fibonacci", 8);
        try {
            System.out.println(fibonacci.runTask(10).get());
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } catch (ExecutionException ex) {
            System.out.println(ex);
        } finally {
            fibonacci.exec.shutdown();
        }
    }
}
