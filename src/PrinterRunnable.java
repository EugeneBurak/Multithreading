/**
 * Created by java_dev on 22.05.17.
 */
public class PrinterRunnable implements Runnable {
    private String name;

    public PrinterRunnable()    {}

    public PrinterRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("I'm printer! PrinterRunnable implements Runnable.");
        System.out.println("Printer name - " + name);
    }
}
