package example;

import java.util.concurrent.*;
import concurrency.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Examle_8 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("Not Waiting daemon thread");
    }
}
