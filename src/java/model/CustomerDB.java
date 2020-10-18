package model;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDB {
    public static ArrayList getCustomers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList custList = new ArrayList();

        String query = "SELECT * FROM customers;";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Customer cust = null;
            while (rs.next()) {
                cust = new Customer(rs.getString("firstName"), rs.getString("lastName"), 
                                    rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getString("postalCode"), rs.getString("countryCode"), rs.getString("phone"), rs.getString("email")); 
                                    
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
}
