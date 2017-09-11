package tutorials;

import java.util.concurrent.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class MyThreadCalcPI3 extends Thread {
    private boolean negative = true;
    double pi;
    public void run() {
        for (int i = 3; i < 100000; i +=2) {
            if (negative) {
                pi -= (1.0 / i);
            } else {
                pi += (1.0 / i);
            }
            negative = !negative;
        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println("Finished calculator Pi");
    }
}
public class CalcPI3 {
    public static void main(String[] args) {
        MyThreadCalcPI3 mt = new MyThreadCalcPI3();
        mt.start();
        try {
            mt.join();
        } catch (InterruptedException ex) {

        }
        System.out.println("Pi = " + mt.pi);
    }
}
