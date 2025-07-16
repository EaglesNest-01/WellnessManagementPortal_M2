package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentDAO {
    public static void insertAppointment(String counsellor, String date, String time, String reason) {
        String sql = "INSERT INTO Appointments (counsellor, date, time, reason) VALUES (?, ?, ?, ?)";
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, counsellor);
            pstmt.setString(2, date);
            pstmt.setString(3, time);
            pstmt.setString(4, reason);
            pstmt.executeUpdate();
            System.out.println("Appointment saved.");
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }
}

