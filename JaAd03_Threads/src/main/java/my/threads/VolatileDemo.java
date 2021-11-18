package my.threads;

public class VolatileDemo {

    //private static boolean stop = false;
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running...");
        Thread t = new Thread(() -> {
            while (!stop) {}
            System.out.println("All done");
        });
        t.start();

        Thread.sleep(1000);
        System.out.println("Command to stop");
        stop = true;
    }
}
