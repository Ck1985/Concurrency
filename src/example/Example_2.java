package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Fibonacci implements Generator<Integer>, Runnable {
    private int n = 0;
    public Fibonacci(int n) {
        this.n = n;
    }
    public Integer next() {
        return calculatorFib(this.n);
    }
    private int calculatorFib(int n) {
        if ((n > 2) || (n == 2)) {
            return calculatorFib(n - 1) + calculatorFib(n - 2);
        } else {
            return 1;
        }
    }
    public void run() {
        System.out.print(next() + " ");
        Thread.yield();
    }
}
public class Example_2 {
    public static void main(String[] args) {
        Fibonacci fib = null;
        Thread thread = null;
        for (int i = 0; i < 20; i++) {
            fib = new Fibonacci(i);
            thread = new Thread(fib);
            thread.start();
        }
        System.out.println("This message in main()");
    }
}
