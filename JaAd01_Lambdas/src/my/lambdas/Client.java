package my.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Client {

    public static void main(String[] args) {
        //Стиль лямбда c применением стандартных функцональных интерфейсов
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);
        var ict = new IntegerCollectionTransformWithStandardFunctionInterface();
        var result =ict.transform(data, x -> x * x * x);
        result =ict.transform(data, x -> x * x );

        Function<Integer, Integer> lambda = x -> x * x * x * x;
        ict.transform(data, lambda).forEach(x -> {
            System.out.println(x);
        });

    }


    public static void main4(String[] args) {
        //Не надо изобретать велосипед: трансформировать, фильтровать и сортировать
        // списки можно с помощью страндратных классов Явы (Stream API)
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);data.add(4); data.add(5);

        data.stream()
                .map(x -> x * x) // здесь использован Function<Integer>
                .filter(x -> x > 10) //здесь использован Predicate<Integer>
                .forEach( x -> { //здесь использован Consumer<Integer>
                    System.out.println(x);
                });

    }

    public static void main3(String[] args) {
        //Стиль лямбда (стрелочных функций) и без классических циклов
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);
        IntegerCollectionTransform ict = new IntegerCollectionTransform();
        var result =ict.transform(data, x -> x * x * x);
        result =ict.transform(data, x -> x * x );

        IntegerTransform lambda = x -> x * x * x * x;
        ict.transform(data, lambda).forEach(x -> {
            System.out.println(x);
        });

    }

    public static void main2(String[] args) {
        //Стиль лямбда (стрелочных функций)
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);
        IntegerCollectionTransform ict = new IntegerCollectionTransform();
//        var result =ict.transform(data, x -> {
//            return  x * x * x;
//        });
        var result =ict.transform(data, x -> x * x * x);
        result =ict.transform(data, x -> x * x );
        IntegerTransform lambda = x -> x * x * x * x;
        result = ict.transform(data, lambda);
        for(var x: result) {
            System.out.println(x);
        };
    }

    public static void main1(String[] args) {
        //Стиль анонимных классов. Неплохо, но тяжелая "конфорка"
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);
        IntegerCollectionTransform ict = new IntegerCollectionTransform();
        var result =ict.transform(data, new IntegerTransform() {
            @Override
            public Integer doTransform(Integer x) {
                return x * x * x;
            }

        });
        for(var x: result) {
            System.out.println(x);
        };
    }

//    public static void main(String[] args) {
//        //Это правильно, но не модно
//        //System.out.println("Hello, world!");
//        List<Integer> data = new ArrayList<>();
//        data.add(1); data.add(2); data.add(3);
//        IntegerCollectionTransform ict = new IntegerCollectionTransform();
//        var result = ict.squares(data);
//        for(var x: result) {
//            System.out.println(x);
//        }
//
//    }
}
