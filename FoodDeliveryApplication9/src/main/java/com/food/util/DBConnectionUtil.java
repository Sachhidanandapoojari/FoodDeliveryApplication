package com.food.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	 static final String JDBC_URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
     static final String JDBC_USERNAME = "root";
     static final String JDBC_PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully!");

            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Driver not found", e);
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            throw e;
        }
        return connection;
    }
}
