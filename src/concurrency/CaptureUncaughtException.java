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
class HandlerThreadFactory {

}
public class CaptureUncaughtException {
    public static void main(String[] args) {

    }
}
