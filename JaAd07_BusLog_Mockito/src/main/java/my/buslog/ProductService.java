package my.buslog;

import my.dal.Product;

import java.util.List;
import java.util.function.Predicate;

public interface ProductService {
    List<Product> allProducts();
    List<Product> productsByFirstLetters(String letters);
    List<Product> productsFiltered(Predicate<Product> filter);
}
