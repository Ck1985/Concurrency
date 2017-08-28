package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void unTimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("TryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2,TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        try {
            System.out.println("TryLock(2,TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.unTimed();
        al.timed();
        //Now create a separate task to grab the lock
        new Thread() {
            {this.setDaemon(true);}
            public void run() {
                al.lock.lock();
                System.out.println("aquirred");
            }
        }.start();
        //Now Give the 2nd teask a chance
        Thread.yield();
        al.unTimed();
        al.timed();
    }
}
