package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
