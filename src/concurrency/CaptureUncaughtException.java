package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class ExceptionThread2 implements Runnable {
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread);
        System.out.println("eh " + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("caught " + throwable);
    }
}
class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        System.out.println(this + " is creating new Thread");
        Thread thread = new Thread(runnable);
        System.out.println(thread + " is created");
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh: " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}
public class CaptureUncaughtException {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
