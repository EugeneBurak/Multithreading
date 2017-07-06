import java.util.concurrent.locks.*;

/**
 * Created by java_dev on 29.05.17.
 */
public class MutexEvenGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // Ускоряем сбой
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

    }
}
