package example;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class LiftOff_1 implements Runnable {
    protected int countDown = 10;
    private static int countTask = 0;
    private final int id = countTask++;
    public LiftOff_1() {}
    public LiftOff_1(int countDown) { this.countDown = countDown; }
    public String status() {
        return "#" + this.id + "(" + (countDown > 0 ? countDown : "lift off ! ") + "), ";
    }
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
        return;
    }
}
public class Example_1 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new LiftOff_1(5));
            thread.start();
        }
        System.out.println("Waiting lift off !");
    }
}
