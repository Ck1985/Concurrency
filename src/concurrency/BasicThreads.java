package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting lift off !");
    }
}
