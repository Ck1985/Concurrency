package example;

import java.util.concurrent.*;
import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class PriorityThreadFactory implements ThreadFactory  {
    private Random random = new Random();
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        switch (random.nextInt(3)) {
            case 0:
                thread.setPriority(Thread.MIN_PRIORITY);
                break;
            case 1:
                thread.setPriority(Thread.NORM_PRIORITY);
                break;
            case 2:
                thread.setPriority(Thread.MAX_PRIORITY);
                break;
            default:
        }
        return thread;
    }
}
