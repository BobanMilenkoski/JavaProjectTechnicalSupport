/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author boban
 */
public class TechnicianDB { 
    
    public static ArrayList getTechnician() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList custList = new ArrayList();

        String query = "SELECT * FROM technicians ;";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Technician cust = null;
            while (rs.next()) {
                cust = new Technician(rs.getString("firstName"), 
                                    rs.getString("lastName"), rs.getString("email"), rs.getString("phone"), rs.getString("password")); 
                                    
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
    
    public static int insert(Technician technician) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO technicians (firstName, lastName, email, phone, password) "
                + "VALUES (?, ?, ?,?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, technician.getFirstName());
            ps.setString(2, technician.getLastName());
            ps.setString(3, technician.getEmail());
            ps.setString(3, technician.getPhone());
            ps.setString(3, technician.getPassword());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void deleteTechnician(String firstName) throws SQLException {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Delete From technicians where firstName= ?";
 
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
 
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }
}

    

