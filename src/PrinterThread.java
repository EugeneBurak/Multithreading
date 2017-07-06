/**
 * Created by java_dev on 22.05.17.
 */
public class PrinterThread extends Thread implements Thread.UncaughtExceptionHandler{
    private String name;

    public PrinterThread()    {}

    public PrinterThread(String name) {
        this.name = name;
    }

    public void run()   {
        System.out.println("I'm printer! PrinterThread extends Thread.");
        System.out.println("Printer name - " + name);

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
