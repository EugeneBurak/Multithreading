/**
 * Created by java_dev on 26.05.17.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10; // Значение по умолчанию
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}

class MainThread {
    public static void main(String[] args) {
//        LiftOff launch = new LiftOff();
//        launch.run();

//        Thread t = new Thread(new LiftOff());
//        t.start();

        for(int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();

        System.out.println(">>>>>>>>>> Waiting for LiftOff >>>>>>>>>>");
    }
}
