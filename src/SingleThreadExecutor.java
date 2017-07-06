import java.util.concurrent.*;

/**
 * Created by java_dev on 26.05.17.
 */
public class SingleThreadExecutor  {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}