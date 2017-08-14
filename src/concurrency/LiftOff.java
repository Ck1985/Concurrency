package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int countTask = 0;
    private final int id = countTask++;
    public LiftOff(){}
    public LiftOff(int countDown) { this.countDown = countDown; }
    public String status() {
        return "#" + this.id + " (" + (countDown > 0 ? countDown : "liftoff!") +"), ";
    }
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
