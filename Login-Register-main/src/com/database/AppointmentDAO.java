package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;

public class AppointmentDAO {
    
    public static boolean testConnection() {
    try (Connection conn = DerbyConnection.getConnection()) {
        return conn.isValid(2); // 2 second timeout
    } catch (SQLException e) {
        System.err.println("Connection test failed: " + e.getMessage());
        return false;
    }
}
    
    
    
    // Create
    public static boolean insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO Appointments (counsellor, date, time, reason) VALUES (?, ?, ?, ?)";
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, appointment.getCounsellor());
            pstmt.setString(2, appointment.getDate());
            pstmt.setString(3, appointment.getTime());
            pstmt.setString(4, appointment.getReason());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        appointment.setId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
        return false;
    }

    // Read all
    public static List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointments";
        
        try (Connection conn = DerbyConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Appointment appointment = new Appointment(
                    rs.getInt("id"),
                    rs.getString("counsellor"),
                    rs.getString("date"),
                    rs.getString("time"),
                    rs.getString("reason")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            System.out.println("Fetch error: " + e.getMessage());
        }
        return appointments;
    }

    // Update
    public static boolean updateAppointment(Appointment appointment) {
        String sql = "UPDATE Appointments SET counsellor = ?, date = ?, time = ?, reason = ? WHERE id = ?";
        
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, appointment.getCounsellor());
            pstmt.setString(2, appointment.getDate());
            pstmt.setString(3, appointment.getTime());
            pstmt.setString(4, appointment.getReason());
            pstmt.setInt(5, appointment.getId());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
        return false;
    }

    // Delete
    public static boolean deleteAppointment(int id) {
        String sql = "DELETE FROM Appointments WHERE id = ?";
        
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
        return false;
    }
}