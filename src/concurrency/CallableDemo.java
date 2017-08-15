package concurrency;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    public String call() {
        return "TaskWithResult has id: " + this.id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException ex) {
                System.out.println(ex);
            } catch (ExecutionException ex) {
                System.out.println(ex);
            } finally {
                exec.shutdown();
            }
        }
    }
}
