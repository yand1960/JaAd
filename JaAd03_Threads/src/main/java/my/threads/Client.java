package my.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) {
        //Решаем проблему ожидания с помощью самописного счетчика
        SlowMeter meter = new SlowMeter();
        int[] meters = {1,2,3,4,5,6,7,8,9};

        List<Measurement> results = new ArrayList<Measurement>();
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger counter = new AtomicInteger();
        counter.set(meters.length);

        Arrays.stream(meters).forEach(n -> {
            Thread thread = new Thread(() -> {
                int result = meter.measure(n);

                //Обеспечиваем синхронный доступ
                // к потоко-небезопасному блоку кода
                lock.lock();
                results.add(new Measurement(n, result));
                lock.unlock();
                counter.decrementAndGet();

            });
            thread.start();
        });

        while(counter.get() > 0) {
        }


        results.stream()
                .sorted((m1,m2) -> m1.id.compareTo(m2.id))
                .forEach(m -> {
            System.out.println(m);
        });
    }

    public static void main3(String[] args) {
        //Решаем проблему вывода в предсказуемом порядке
        SlowMeter meter = new SlowMeter();
        int[] meters = {1,2,3,4,5,6,7,8,9};

        List<Measurement> results = new ArrayList<Measurement>();
        ReentrantLock lock = new ReentrantLock();

        Arrays.stream(meters).forEach(n -> {
            Thread thread = new Thread(() -> {
                int result = meter.measure(n);
                //Данная строка кода потоко-небезопасна
                //results.add(new Measurement(n, result));

                //Обеспечиваем синхронный доступ
                // к потоко-небезопасному блоку кода
                lock.lock();
                results.add(new Measurement(n, result));
                lock.unlock();

            });
            thread.start();
        });

        //Это работает, но это коряво
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        results.stream()
                .sorted((m1,m2) -> m1.id.compareTo(m2.id))
                .forEach(m -> {
                    System.out.println(m);
                });
    }

    public static void main2(String[] args) {
        //Минимальный асинхронный код
        //На вид совсем просто, но необходимые решения
        // проблем синхронизации весьма сложны - см. далее
        SlowMeter meter = new SlowMeter();
        int[] meters = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(meters).forEach(n -> {
            Thread thread = new Thread(() -> {
                int result = meter.measure(n);
                System.out.println(result);
            });
            thread.start();
        });
    }

    public static void main1(String[] args) {
        //При наличии задержки синхронный код неудовлетворителен
        SlowMeter meter = new SlowMeter();
        int[] meters = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(meters).forEach(n -> {
            int result = meter.measure(n);
            System.out.println(result);
        });
    }
}

class Measurement {
    public Integer id;
    public Integer value;

    public Measurement(int id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return id + "-" + value;
    }
}
