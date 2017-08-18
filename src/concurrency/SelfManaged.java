package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread thread = new Thread(this);
    public SelfManaged() {
        thread.start();
    }
    public String toString() {
        return Thread.currentThread().getName() + "(" + this.countDown + "), ";
    }
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
