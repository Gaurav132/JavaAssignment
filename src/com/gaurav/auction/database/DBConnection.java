/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nishan Dhungana
 */
public class DBConnection {
    
    private static String url;
    private static String username;
    private static String password;
    
    public DBConnection() {
        url = "jdbc:sqlserver://localhost:1433;databaseName=auction";
        username = "root";
        password = "";
    }
    
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, url, password);
            
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return connection;
    }
}
