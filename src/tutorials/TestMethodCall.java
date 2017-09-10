package tutorials;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Foo {
    private int x;
    public Foo(int val) {
        this.x = val;
    }
    public void setVal(int val) {
        this.x = val;
    }
    public int getVal() {
        return this.x;
    }
    public int plus(Foo foo, int val) {
        int result;
        result = foo.getVal() + this.x + val;
        return result;
    }
}
public class TestMethodCall {
    public static void main(String[] args) {
        Foo f1,f2;
        int x = 8;
        f1 = new Foo(10);
        f2 = new Foo(12);
        f1.setVal(x);
        x = f1.plus(f2, x);
    }
}
