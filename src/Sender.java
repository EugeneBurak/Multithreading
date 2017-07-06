//: concurrency/PipedIO.java
// Использование каналов для ввода/вывода между потоками
import java.util.concurrent.*;
import java.io.*;
import java.util.*;

/**
 * Created by java_dev on 29.05.17.
 */
public class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter() { return out; }
    public void run() {
        try {
            while(true)
                for(char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch(IOException e) {
            Print.print(e + " Sender write exception");
        } catch(InterruptedException e) {
            Print.print(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }
    public void run() {
        try {
            while(true) {
                // Блокируется до появления следующего символа:
                Print.print("Read: " + (char)in.read() + ", ");
            }
        } catch(IOException e) {
            Print.print(e + " Receiver read exception");
        }
    }
}

class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}