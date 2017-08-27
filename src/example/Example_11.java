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
        }
    }
}
class NumberRangeGenerator11 {

}
public class Example_11 {
}
