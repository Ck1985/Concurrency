package example;

import java.util.concurrent.*;
import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class SecurityMan implements Runnable {
    private Random random = new Random(10);
    private int walk = 10;
    private static int count = 0;
    private final int id = count++;
    public SecurityMan(int walk) {
        this.walk = walk;
    }
    public void run() {
        int countWalk = 0;
        while (countWalk++ < walk) {
            try {
                System.out.print("SecurityMan #" + this.id + " walk: " + countWalk);
                int timeSLeep = random.nextInt(10000);
                System.out.println("I need some rest about: " + timeSLeep);
                TimeUnit.MILLISECONDS.sleep(timeSLeep);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
public class Example_6 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            exec.execute(new SecurityMan(10));
        }
        exec.shutdown();
    }
}
