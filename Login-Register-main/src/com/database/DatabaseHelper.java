package com.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    public static void execute(String sql) throws SQLException {
        try (Connection conn = DerbyConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }
}
