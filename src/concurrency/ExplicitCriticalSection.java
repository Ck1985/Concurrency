package concurrency;

import java.util.concurrent.locks.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}
class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
public class ExplicitCriticalSection {
    public static void main(String[] args) throws Exception {
        PairManager
                pm1 = new ExplicitPairManager1(),
                pm2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pm1,pm2);
    }
}
