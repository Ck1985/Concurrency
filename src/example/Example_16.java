package example;

import java.util.concurrent.locks.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class SyncTestOneLock { //Using one lock
    private Lock lock = new ReentrantLock();
    public void f1() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("f1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void g1() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("g1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void h1() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("h1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
}
class SyncTestManyLock { //Using many lock
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();
    public void f2() {
        lock1.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("f2()");
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }
    public void g2() {
        lock2.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("g2()");
                Thread.yield();
            }
        } finally {
            lock2.unlock();
        }
    }
    public void h2() {
        lock3.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("h2()");
                Thread.yield();
            }
        } finally {
            lock3.unlock();
        }
    }
}
public class Example_16 {
    public static void main(String[] args) {
        SyncTestOneLock stol = new SyncTestOneLock();
        SyncTestManyLock stml = new SyncTestManyLock();
        /*new Thread() {
            public void run() {
                stol.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                stol.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                stol.h1();
            }
        }.start();*/
        new Thread() {
            public void run() {
                stml.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                stml.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                stml.h2();
            }
        }.start();
    }
}
