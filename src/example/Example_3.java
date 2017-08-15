package example;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class RunnerA implements Runnable {
    public RunnerA() {
        System.out.println("RunnerA Constructor");
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hi in RunnerA");
            Thread.yield();
        }
        System.out.println("RunnerA task completes");
        return;
    }
}
class RunnerB implements Runnable {
    public RunnerB() {
        System.out.println("RunnerB Constructor");
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hi in RunnerB");
            Thread.yield();
        }
        System.out.println("RunnerB task completes");
        return;
    }
}
class RunnerC implements Runnable {
    public RunnerC() {
        System.out.println("RunnerC Constructor");
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hi in RunnerC");
            Thread.yield();
        }
        System.out.println("RunnerC task complement");
        return;
    }
}
public class Example_3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new RunnerA());
        exec.execute(new RunnerB());
        exec.execute(new RunnerC());
        exec.shutdown();
        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        exec2.execute(new RunnerA());
        exec2.execute(new RunnerB());
        exec2.execute(new RunnerC());
        exec2.shutdown();
        ExecutorService exec3 = Executors.newSingleThreadExecutor();
        exec3.execute(new RunnerA());
        exec3.execute(new RunnerB());
        exec3.execute(new RunnerC());
        exec3.shutdown();
    }
}
