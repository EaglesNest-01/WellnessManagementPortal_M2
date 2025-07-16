package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyConnection {

    private static final String DB_URL ="jdbc:derby:C:\\Users\\JANE\\OneDrive\\Documents\\m2_WellnessApp\\WellnessManagementPortal_M2\\Database\\WellnessDB;create=true";
            /*"jdbc:derby:D:\\CODE\\WellnessManagementPortal_M2\\Database\\WellnessDB;create=true"*/;
    
    private static Connection conn = null;

    

    public static Connection getConnection() {
        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Embedded Derby DB connected.");
        } catch (ClassNotFoundException e) {
            System.out.println("Embedded Driver not found: " + e);
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
        return conn;
    }
}

