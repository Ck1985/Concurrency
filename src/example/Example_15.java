package example;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class SyncTest_1 {
    public void f1() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f1()");
                Thread.yield();
            }
        }
    }
    public void g1() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g1()");
                Thread.yield();
            }
        }
    }
    public void h1() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("h1()");
                Thread.yield();
            }
        }
    }
}
class SyncTest_2 {
    private Object
                object1 = new Object(),
                object2 = new Object(),
                object3 = new Object();
    public void f2() {
        synchronized(object1) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f2()");
                Thread.yield();
            }
        }
    }
    public void g2() {
        synchronized (object2) {
            for (int i = 0; i < 5; i ++) {
                System.out.println("g2()");
                Thread.yield();
            }
        }
    }
    public void h2() {
        synchronized(object3) {
            for (int i = 0; i < 5; i++) {
                System.out.println("h2()");
                Thread.yield();
            }
        }
    }
}
public class Example_15 {
    public static void main(String[] args) {
        final SyncTest_1 st1 = new SyncTest_1();
        final SyncTest_2 st2 = new SyncTest_2();
        new Thread() {
            public void run() {
                st1.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.h1();
            }
        }.start();
        //System.out.println("-----------------");
        new Thread() {
            public void run() {
                st2.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.h2();
            }
        }.start();
    }
}
