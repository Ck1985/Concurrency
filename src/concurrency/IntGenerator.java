package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        this.canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
