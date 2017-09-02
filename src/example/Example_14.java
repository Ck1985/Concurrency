package example;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Example_14 implements Runnable {
    private static int timer = 0;
    private static int task = 0;
    public void run() {
        try {
            while (timer < 4000) {
                ++timer;
                Timer t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        ++task;
                        if (timer % 100 == 0) {
                            System.out.println(timer + " timer id " + task + " task");
                        }
                    }
                },0);
                try {
                    TimeUnit.MILLISECONDS.sleep(30);
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted sleep");
                }
                t.cancel();
            }
        } finally {
            System.out.println("Done " + timer + " timer " + task + " task");
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Example_14());
        exec.shutdown();
    }
}
