package my.threads;

public class SlowMeter {

    public int measure(int n) {
        try {
            if (n == 5)
                Thread.sleep(30000);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var result = n * 10;
        return result;
    }

}
