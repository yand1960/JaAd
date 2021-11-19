package my.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.buslog.ProductService;
import my.buslog.ProductServiceImpl;
import my.dal.Product;
import my.dal.RepositoryJDBC;

import java.io.IOException;
import java.util.List;

@WebServlet(name="products", urlPatterns = {"/api/products"})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl(
            new RepositoryJDBC()
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.allProducts();
        resp.getWriter().println(products.size());
    }
}
