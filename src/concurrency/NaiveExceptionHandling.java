package concurrency;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ex) {
            System.out.println("Runtimeexception is handled");
        }
    }
}
