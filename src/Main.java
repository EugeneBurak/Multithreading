public class Main {

    public static void main(String[] args) {
        PrinterRunnable printer = new PrinterRunnable();
        Thread thread = new Thread(printer);
        thread.start();
/*
        PrinterRunnable printerHp = new PrinterRunnable("HP");
        Thread threadHp = new Thread(printerHp);
        PrinterRunnable printerCanon = new PrinterRunnable("Canon");
        Thread threadCanon = new Thread(printerCanon);
        PrinterRunnable printerEpson = new PrinterRunnable("Epson");
        Thread threadEpson = new Thread(printerEpson);
        threadEpson.start();
        threadCanon.start();
        threadHp.start();
        try {
            threadEpson.join();
            threadCanon.join();
            threadHp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        PrinterThread printerThread = new PrinterThread();
        printerThread.start();

        CallableSample callableSample = new CallableSample();
        try {
            callableSample.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        NewThread ob1 = new NewThread("Одни");
        NewThread ob2 = new NewThread("Два");
        NewThread ob3 = new NewThread("Три");
        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: " + ob2.t.isAlive());
        System.out.println("Поток Три запущен: " + ob3.t.isAlive());
// ожидать завершения потоков
        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join () ;
            ob2.t.join () ;
//            ob3.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: " + ob2.t.isAlive());
        System.out.println("Поток Три запущен: " + ob3.t.isAlive());
        System.out.println("Главный поток завершен.");

    }
}
