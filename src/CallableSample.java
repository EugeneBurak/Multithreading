import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by java_dev on 18.05.17.
 */
public class CallableSample implements Callable<String> {
    @Override
    public String call() throws Exception {
        //          Some works
        if(false) {         //          condition
            throw new IOException("error during task processing");
        }
        return "result";
    }
}
