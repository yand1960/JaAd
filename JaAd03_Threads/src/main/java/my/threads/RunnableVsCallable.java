package my.threads;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableVsCallable {

    public static void main(String[] args) {

        try {
            //Callable похоже на поток, но может возвразщать значение
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = -2; i < 5; i++) {
//                        System.out.println(1 / i);
                        sum += i;

                    }
                    return sum;
                }
            };

            //Выполняется callable посредством так нахываемого executor
            ExecutorService executor = Executors.newFixedThreadPool(20);
            //Future - это фактически запущенная на расчет задача,
            // которая, возможно, будет выполняться долго
            Future<Integer> future = executor.submit(task);

            //Ждем получения результата этой задачи
            System.out.println(future.get());

            //Executor нужно прекращать явным образом
            executor.shutdown();
        }
        catch (Exception e) {
            //Обработчик ошибок работает на сновном потоке и срабатывает
            // при получении результата задачи методом get()
            System.out.println("Some error");
        }

    }

    public static void main1(String[] args) {

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = -4; i < 5; i++) {
                        System.out.println(1 / i);

                    }
                }
            });

            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("ERR in THREAD");
                }
            });
            thread.start();
        }
        catch (Exception e) {
            System.out.println("ERRR!");
        }

    }

}
