package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 6; i++) {
            thread = new Thread(new LiftOff());
            thread.start();
        }
        System.out.println("Waiting lift off !");
    }
}
