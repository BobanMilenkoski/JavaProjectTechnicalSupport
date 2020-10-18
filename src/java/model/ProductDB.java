package model;
import java.sql.*;
import java.util.ArrayList;

public class ProductDB {
    public static ArrayList getProducts() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList custList = new ArrayList();

        String query = "SELECT * FROM products;";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Product cust = null;
            while (rs.next()) {
                cust = new Product(rs.getString("productCode"), rs.getString("name"), 
                                    rs.getString("version"), rs.getString("releaseDate")); 
                                    
                custList.add(cust);				
            }
            return custList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    public static int insert(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO products (productCode, name, version, releaseDate) "
                + "VALUES (?, ?, ?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductCode());
            ps.setString(2, product.getName());
            ps.setString(3, product.getVersion());
            ps.setString(3, product.getReleaseDate());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void deleteProduct(String productCode) throws SQLException {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Delete From products where productCode= ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
 
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }

}

