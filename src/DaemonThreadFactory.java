import java.util.concurrent.ThreadFactory;

/**
 * Created by java_dev on 26.05.17.
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
