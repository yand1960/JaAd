package my.buslog.tests;

import my.buslog.ProductService;
import my.buslog.ProductServiceImpl;
import my.dal.RepositoryJDBC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsServiceTest {

    @Test
    public void allProductsTest() {
        ProductService service =
                new ProductServiceImpl(new RepositoryJDBC());
        var result = service.allProducts();
        Assertions.assertEquals(504, result.size());
    }

    @Test
    public void productsByFirstLettersTest() {
        ProductService service =
                new ProductServiceImpl(new RepositoryJDBC());
        var result = service.productsByFirstLetters("a");
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void productsFilteredTest() {
        ProductService service =
                new ProductServiceImpl(new RepositoryJDBC());
        var result = service.productsFiltered(p -> p.getPrice() > 3000);
        Assertions.assertEquals(13, result.size());
    }

}
