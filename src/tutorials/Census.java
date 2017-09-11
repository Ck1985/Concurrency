package tutorials;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Census {
    public static void main(String[] args) {
        Thread[] threads = new Thread[Thread.activeCount()];
        int n = Thread.enumerate(threads);
        for (int i = 0; i < n; i++) {
            System.out.println(threads[i].toString());
        }
    }
}
