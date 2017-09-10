package tutorials;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class MyThreadCalcPI1 extends Thread {
    private boolean negative = true;
    public double pi;
    public void run() {
        for (int i = 3; i < 100000; i += 2) {
            if (negative) {
                pi -= (1.0 / i);
            } else {
                pi += (1.0 / i);
            }
            negative = !negative;
        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println("Finishing calculator PI");
    }
}
public class CalcPI1 {
    public static void main(String[] args) {
        MyThreadCalcPI1 mt = new MyThreadCalcPI1();
        mt.start();
        try {
            //Thread.sleep(10);
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("Sleep Interrupted");
        }
        System.out.println("PI: " + mt.pi);
    }
}
