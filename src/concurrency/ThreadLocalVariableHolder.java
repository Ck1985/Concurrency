package concurrency;

import java.util.concurrent.*;
import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Accessor implements Runnable {
    private final int id;
    public Accessor(int idn) {
        this.id = idn;
    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

        }
    }
    public String toString() {

    }
}
public class ThreadLocalVariableHolder {
    public static void main(String[] args) {

    }
}
