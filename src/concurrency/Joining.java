package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        this.duration = sleepTime;
        start();
    }
    public void run() {
        try {
            this.sleep(duration);
        } catch (InterruptedException ex) {
            System.out.println(this.getName() + " was interrupted, is Interrupted: " + this.isInterrupted());
            return;
        }
        System.out.println(this.getName() + " has waken up");
    }
}
class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println(this.getName() + " join completed");
    }
}
public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grampy = new Sleeper("Grampy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grampy);
        grampy.interrupt();
    }
}
