package concurrency;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Count {
    private int count = 0;
    private Random random = new Random(47);
    //Remove synchronized keyword to see counting fail
    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return this.count = ++temp;
    }
    public synchronized int value() {
        return this.count;
    }
}
class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int numberThroughEntrance = 0;
    //Don't need synchronization to read
    private final int id;
    private static volatile boolean canceled = false;
    //Atomic operator on volatile field
    public static void cancel() {
        canceled = true;
    }
    public Entrance(int id) {
        this.id = id;
        //Keep task in list. Also prevents Garbage collection of dead task
        entrances.add(this);
    }
    public void run() {
        while (!canceled) {
            synchronized(this) {
                ++this.numberThroughEntrance;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stop " + this);
    }
    public synchronized int getValue() {
        return this.numberThroughEntrance;
    }
}
public class OrnamentalGarden {
    public static void main(String[] args) {

    }
}
