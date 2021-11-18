package my.buslog;

import my.dal.Product;
import my.dal.Repository;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    private List<Product> products;

    public ProductServiceImpl(Repository repository) {
        products = repository.getProducts();
    }

    @Override
    public List<Product> allProducts() {
        return products;
    }

    @Override
    public List<Product> productsByFirstLetters(String letters) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase(Locale.ROOT).startsWith(letters.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> productsFiltered(Predicate<Product> filter) {
        return products.stream()
                .filter(p -> filter.test(p))
                .collect(Collectors.toList());
    }

}
