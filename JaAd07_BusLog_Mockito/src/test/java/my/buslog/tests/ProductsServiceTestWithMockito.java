package my.buslog.tests;

import my.buslog.ProductService;
import my.buslog.ProductServiceImpl;
import my.dal.Product;
import my.dal.Repository;
import my.dal.RepositoryJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProductsServiceTestWithMockito {

    Repository mock;

    public ProductsServiceTestWithMockito() {
        mock = Mockito.mock(Repository.class);
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"lala", "qqqq", 123.0));
        products.add(new Product(2,"bubu", "qqqq", 123.0));
        Mockito.when(mock.getProducts()).thenReturn(products);
    }

    @Test
    public void allProductsTest() {
        ProductService service =
                new ProductServiceImpl(mock);

        var result = service.allProducts();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void productsByFirstLettersTest() {
        ProductService service =
                new ProductServiceImpl(mock);
        var result = service.productsByFirstLetters("la");
        Assertions.assertEquals(1, result.size());
    }

    //@Test
    public void productsFilteredTest() {
        ProductService service =
                new ProductServiceImpl(new RepositoryJDBC());
        var result = service.productsFiltered(p -> p.getPrice() > 3000);
        Assertions.assertEquals(13, result.size());
    }

}
