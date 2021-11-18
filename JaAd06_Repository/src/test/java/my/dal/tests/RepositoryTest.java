package my.dal.tests;

import my.dal.Repository;
import my.dal.RepositoryJDBC;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void getProductsTest() {
        Repository repository = new RepositoryJDBC();
        var result = repository.getProducts();
        System.out.println(result.get(0).getName());
    }
}
