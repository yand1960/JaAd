package my.dbs;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {
        String db_url = "jdbc:sqlserver://yand.dyndns.org;databaseName=AdventureWorks;";
        double min_price = 3000.0;

        try(Connection cn = DriverManager.getConnection(db_url,"northwind" ,"northwind")) {
            String sql = "SELECT ProductID, Name, ProductNumber, ListPrice " +
                    "FROM Production.Product " +
                    "WHERE ListPrice > ?";
            PreparedStatement stat = cn.prepareStatement(sql);
            stat.setDouble(1,min_price);
            try(ResultSet rs = stat.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("Name") + " - " + rs.getDouble("ListPrice"));
                }
            }
        }
    }

}
