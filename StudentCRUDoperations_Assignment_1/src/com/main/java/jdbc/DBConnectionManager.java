package com.main.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {

    private static Connection con;

    public static Connection connectDB() {

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "Ashwini@1";

            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println("Database Connection Failed : " + e.getMessage());
        }

        return con;
    }
}
