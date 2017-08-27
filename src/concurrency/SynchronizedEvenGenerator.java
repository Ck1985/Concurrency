package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
