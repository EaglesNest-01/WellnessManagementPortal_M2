package com.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTableCreator {

    public static void createTables() {
    try (Connection conn = DerbyConnection.getConnection();
         Statement stmt = conn.createStatement()) {

        // DROP tables first (ignore errors if they don't exist)
        String[] dropStatements = {
            "DROP TABLE APP.APPOINTMENTS",
            "DROP TABLE APP.FEEDBACK",
            "DROP TABLE APP.ADMIN",
            "DROP TABLE APP.COUNSELORS"
        };

        for (String dropSQL : dropStatements) {
            try {
                stmt.executeUpdate(dropSQL);
                System.out.println("Dropped table: " + dropSQL);
            } catch (SQLException e) {
                System.out.println("Table not found or already dropped: " + dropSQL);
            }
        }

        // 1. Counselors table
        String createCounselors = "CREATE TABLE APP.COUNSELORS ("
                + "EMP_ID VARCHAR(10) PRIMARY KEY, "
                + "NAME VARCHAR(100), "
                + "SPECIALIZATION VARCHAR(100), "
                + "AVAILABILITY VARCHAR(50))";

        // 2. Appointments table
        String createAppointments = "CREATE TABLE APP.APPOINTMENTS ("
                + "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "COUNSELLOR_ID VARCHAR(10), "
                + "DATE VARCHAR(50), "
                + "TIME VARCHAR(50), "
                + "REASON VARCHAR(255), "
                + "PRIMARY KEY (ID), "
                + "FOREIGN KEY (COUNSELLOR_ID) REFERENCES APP.COUNSELORS(EMP_ID))";

        // 3. Feedback table
        String createFeedback = "CREATE TABLE APP.FEEDBACK ("
                + "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "COMMENT VARCHAR(500), "
                + "RATING INT, "
                + "PRIMARY KEY (ID))";

        // 4. Admin table
        String createAdmin = "CREATE TABLE APP.ADMIN ("
                + "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "NAME VARCHAR(100), "
                + "EMAIL VARCHAR(100) UNIQUE, "
                + "PASSWORD VARCHAR(100), "
                + "GENDER VARCHAR(10), "
                + "PRIMARY KEY (ID))";

        // Create tables
        stmt.executeUpdate(createCounselors);
        stmt.executeUpdate(createAppointments);
        stmt.executeUpdate(createFeedback);
        stmt.executeUpdate(createAdmin);

        System.out.println("✅ All tables created.");
    } catch (SQLException e) {
        System.out.println("❌ Table creation failed:");
        e.printStackTrace();
    }
}
}

