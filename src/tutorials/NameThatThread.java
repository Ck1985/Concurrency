package tutorials;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class MyThread_2 extends Thread {
    public MyThread_2(){}
    public MyThread_2(String name) {
        super(name);
    }
    public void run() {
        System.out.println("My name is: " + getName());
    }
}
public class NameThatThread {
    public static void main(String[] args) {
        MyThread_2 mt;
        if (args.length == 0) {
            mt = new MyThread_2();
        } else {
            mt = new MyThread_2(args[0]);
        }
        mt.start();
    }
}
