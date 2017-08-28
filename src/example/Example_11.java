package example;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
abstract class NumberRangeGenerator {
    private volatile boolean canceled = false;
    public abstract int[] next();
    public void cancel() {
        this.canceled = true;
    }
    public boolean isCanceled() {
        return this.canceled;
    }
}
class NumberRangeChecker11 implements Runnable {
    private NumberRangeGenerator generator;
    private final int id;
    public NumberRangeChecker11(NumberRangeGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }
    public void run() {
        System.out.println("Testing ....");
        while (!generator.isCanceled()) {
            int[] range = generator.next();
            if (range[0] > range[1]) {
                System.out.println("Error in testing #" + this.id + " --- min: " + range[0] + " > max: " + range[1]);
                generator.cancel();
            }
        }
    }
    public static void test(NumberRangeGenerator generator, int count) {
        System.out.println("Press Ctrl-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new NumberRangeChecker11(generator,i));
        }
        exec.shutdown();
    }
    public static void test(NumberRangeGenerator generator) {
        test(generator,10);
    }
}
class NumberRangeGenerator11 extends NumberRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random random = new Random();
    public int[] next() {
        min = random.nextInt(100);
        max = random.nextInt(100);
        Thread.yield();
        if (min > max) {
            max = min;
        }
        int[] ia = {min, max};
        return ia;
    }
}
class SynchronizedNumberRangeGenerator11 extends NumberRangeGenerator {
    private int min  = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random random = new Random();
    public synchronized int[] next() {
        min = random.nextInt(100);
        max = random.nextInt(100);
        Thread.yield();
        if (min > max) {max = min;}
        int[] ia = {min, max};
        return ia;
    }
}
public class Example_11 {
    public static void main(String[] args) {
        //NumberRangeChecker11.test(new NumberRangeGenerator11());
        NumberRangeChecker11.test(new SynchronizedNumberRangeGenerator11());
    }
}
