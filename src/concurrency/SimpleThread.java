package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int countThread = 0;
    public SimpleThread() {
        super(Integer.toString(++countThread));
        start();
    }
    public String toString() {
        return "#" + getName() + "(" + this.countDown + "), ";
    }
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
