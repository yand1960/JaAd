package my.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class IntegerCollectionTransformWithStandardFunctionInterface {

    //Не обязaтельно писать свои собственные функциональные интрерфейсы.
    // Можно использовать готовые

    public List<Integer> transform(List<Integer> data, Function<Integer, Integer> transform) {
        List<Integer> result = new ArrayList<>();
        for(int x: data) {
            result.add(transform.apply(x));
        }
        return result;
    }
}
