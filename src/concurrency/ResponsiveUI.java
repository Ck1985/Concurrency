package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class UnResponsiveUI {
    private volatile double d = 1;
    public UnResponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        this.setDaemon(true);
        this.start();
    }
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }
    public static void main(String[] args) throws Exception {
        //new UnResponsiveUI();
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
