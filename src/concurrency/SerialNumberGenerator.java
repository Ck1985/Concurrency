package concurrency;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++; //Not Thread safe;
    }
}
