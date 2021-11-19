package my.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.cfg.JaxRSFeature;
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
        //List<Product> products = productService.allProducts();

        String letters = req.getParameter("letters").toString();
        List<Product> products = productService.productsByFirstLetters(letters);

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().println(
                mapper.writeValueAsString(products)
        );
    }
}
