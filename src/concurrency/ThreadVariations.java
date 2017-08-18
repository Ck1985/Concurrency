package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
//Using a named inner class
class InnerThread_1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }
        public void run() {
            try {
                while (true) {
                    System.out.print(this);
                    if (--countDown == 0) return;
                    sleep(10);
                }
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
        }
        public String toString() {
            return this.getName() + ": " + countDown;
        }
    }
    public InnerThread_1(String name) {
        inner = new Inner(name);
    }
}
//Using anonymous inner class
class InnerThread_2 {
    private int countDown = 5;
    private Thread thread;
    public InnerThread_2(String name) {
        thread = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.print(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("sleep() Interrupted");
                }
            }
            public String toString() {
                return this.getName() + ": " + countDown;
            }
        };
        thread.start();
    }
}
//Using named Runnable implementation
class InnerRunnable_1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner implements Runnable {
        Thread thread;
        public Inner(String name) {
            thread = new Thread(this,name);
            thread.start();
        }
        public void run() {
            try {
                while (true) {
                    System.out.print(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException ex) {
                System.out.println("sleep() interrupted");
            }
        }
        public String toString() {
            return thread.getName() + ": " + countDown;
        }
    }
}
//Using an anonymous Runnable implementation
class InnerRunnable_2 {
    private int countDown = 5;
    private Thread thread;
    public InnerRunnable_2(String name) {
        thread = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.print(this);
                        if (--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("sleep(0 Interrupted");
                }
            }
            public String toString() {
                return thread.getName() + ": " + countDown;
            }
        }, name);
        thread.start();
    }
}
//A seperate method to run code task
class ThreadMethod {

}
public class ThreadVariations {
    public static void main(String[] args) {

    }
}
