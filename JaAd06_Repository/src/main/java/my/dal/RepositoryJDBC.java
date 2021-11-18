package my.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryJDBC implements Repository {

    private List<Product> products = new ArrayList<>();

    public RepositoryJDBC() {
        this("jdbc:sqlserver://yand.dyndns.org;databaseName=AdventureWorks;",
                "northwind",
                "northwind");
    }

    public RepositoryJDBC(String url, String user, String pwd){

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error in repository. See log.");
        }

        try(Connection cn = DriverManager.getConnection(url,user ,pwd)) {
            String sql = "SELECT ProductID, Name, ProductNumber, ListPrice " +
                    "FROM Production.Product ";
            PreparedStatement stat = cn.prepareStatement(sql);
            try(ResultSet rs = stat.executeQuery()) {
                while (rs.next()) {
                   products.add(new Product(rs.getInt("ProductID"),
                                    rs.getString("Name"),
                                    rs.getString("ProductNumber"),
                                    rs.getDouble("ListPrice")
                           ));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in repository. See log.");
        }

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
