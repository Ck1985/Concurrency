package concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Pair { //Not Thread-safe
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() {
        this(0,0);
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void incrementX() {
        this.x++;
    }
    public void incrementY() {
        this.y++;
    }
    public String toString() {
        return "X: " + this.x + ", Y: " + this.y;
    }
    public class PairValuesNotEqualException extends RuntimeException{
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }
    public void checkState() { //Arbitrary Invariant --- both variables must be equal:
        if (this.x != this.y) {
            throw new PairValuesNotEqualException();
        }
    }
}
abstract class PairManager { //Protected a Pair in a Thread-safe class:
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair() {
        //Make a copy to keep original safe
        return new Pair(p.getX(),p.getY());
    }
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {

        }
    }
    public abstract void increment();
}
//Synchronize entire method
class PairManager1 extends PairManager {
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
//Use a critical part
class PairManager2 extends PairManager {
    public void increment() {
        Pair temp;
        synchronized(this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }
    public void run() {
        while (true) {
            pm.increment();
        }
    }
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}
class PairChecker implements Runnable {
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
public class CrriticalSection {
    //Test two difference approaches
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker
                pCheck1 = new PairChecker(pman1),
                pCheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pCheck1);
        exec.execute(pCheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }
    public static void main(String[] args) {
        PairManager
                pman1 = new PairManager1(),
                pman2 = new PairManager2();
        testApproaches(pman1,pman2);
    }
}
