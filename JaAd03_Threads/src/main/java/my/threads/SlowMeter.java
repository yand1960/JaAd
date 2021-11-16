package my.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SlowMeter {


    //Executor отвечает за запуск задач
    private ExecutorService executor =
            Executors.newFixedThreadPool(20);

    public int measure(int n) {
        try {
//            if (n == 5)
//                Thread.sleep(30000);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var result = n * 10;
        return result;
    }

    //Асинхронная обертка над measure
    public Future<Integer> measureAsync(int n) {
        return executor.submit(() -> measure(n));
    }

    //Executorы нужно явным образом выключать
    public void shutdown() {
        executor.shutdown();
    }

}
