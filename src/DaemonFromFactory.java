import java.util.concurrent.*;
/**
 * Created by java_dev on 26.05.17.
 */
public class DaemonFromFactory implements Runnable {
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch(InterruptedException e) {
            print("Interrupted");
        }
    }

    private void print(String interrupted) {
        System.out.println(interrupted);
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(
                new DaemonThreadFactory());
        for(int i = 0; i < 10; i++)
            exec.execute(new DaemonFromFactory());
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500); // Задержка
    }
} /* (Execute to see output) *///:~