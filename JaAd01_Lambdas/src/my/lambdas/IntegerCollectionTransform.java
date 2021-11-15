package my.lambdas;

import java.util.ArrayList;
import java.util.List;


//public class IntegerCollectionTransform {
//
//    public List<Integer> squares(List<Integer> data) {
//        List<Integer> result = new ArrayList<>();
//        for(int x: data) {
//            result.add(x * x);
//        }
//        return result;
//    }
//}

public class IntegerCollectionTransform {

    public List<Integer> transform(List<Integer> data, IntegerTransform transform) {
        List<Integer> result = new ArrayList<>();
        for(int x: data) {
            result.add(transform.doTransform(x));
        }
        return result;
    }
}
