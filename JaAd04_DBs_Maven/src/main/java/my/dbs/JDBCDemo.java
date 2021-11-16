package my.dbs;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {
        String db_url = "jdbc:sqlserver://yand.dyndns.org;databaseName=AdventureWorks;";
        Connection cn = DriverManager.getConnection(db_url,"northwind" ,"northwind");

        String sql = "SELECT ProductID, Name, ProductNumber, ListPrice FROM Production.Product";
        Statement stat = cn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("Name") + " - " + rs.getDouble("ListPrice"));
        }
        rs.close();
        cn.close();
    }

}
