package tutorials;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class MyThreadCalcPI2 extends Thread {
    private boolean negative = true;
    double pi;
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
        System.out.println("Finished Calculator Pi");
    }
}
public class CalcPI2 {
    public static void main(String[] args) {
        MyThreadCalcPI2 mt = new MyThreadCalcPI2();
        mt.start();
        while (mt.isAlive()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Pi = " + mt.pi);
    }
}
