import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by java_dev on 26.05.17.
 */
public class CachedThreadPool{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
