package my.lambdas;

//Функциональный интерфейс - интерфейс ровно с одним методом

@FunctionalInterface
public interface IntegerTransform {
    Integer doTransform(Integer x);
}
