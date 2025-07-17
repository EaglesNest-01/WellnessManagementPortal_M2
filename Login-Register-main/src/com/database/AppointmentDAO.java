package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;

public class AppointmentDAO {

    // Test DB Connection
    public static boolean testConnection() {
        try (Connection conn = DerbyConnection.getConnection()) {
            return conn.isValid(2);
        } catch (SQLException e) {
            System.err.println("Connection test failed: " + e.getMessage());
            return false;
        }
    }

    // CREATE Appointment
    public static boolean insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO APP.APPOINTMENTS (COUNSELLOR_ID, DATE, TIME, REASON) VALUES (?, ?, ?, ?)";
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, appointment.getCounsellor());
            pstmt.setString(2, appointment.getDate());
            pstmt.setString(3, appointment.getTime());
            pstmt.setString(4, appointment.getReason());

            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        appointment.setId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Insert error: " + e.getMessage());
        }
        return false;
    }

    // READ All Appointments
    public static List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM APP.APPOINTMENTS";

        try (Connection conn = DerbyConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Appointment appointment = new Appointment(
                    rs.getInt("ID"),
                    rs.getString("COUNSELLOR_ID"),
                    rs.getString("DATE"),
                    rs.getString("TIME"),
                    rs.getString("REASON")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            System.err.println("Fetch error: " + e.getMessage());
        }
        return appointments;
    }

    // UPDATE by ID – full update (counsellor, date, time, reason)
    public static boolean updateAppointment(Appointment appointment) {
        String sql = "UPDATE APP.APPOINTMENTS SET COUNSELLOR_ID = ?, DATE = ?, TIME = ?, REASON = ? WHERE ID = ?";

        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, appointment.getCounsellor());
            pstmt.setString(2, appointment.getDate());
            pstmt.setString(3, appointment.getTime());
            pstmt.setString(4, appointment.getReason());
            pstmt.setInt(5, appointment.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update error: " + e.getMessage());
        }
        return false;
    }

    // DELETE by ID
    public static boolean deleteAppointment(int id) {
        String sql = "DELETE FROM APP.APPOINTMENTS WHERE ID = ?";

        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete error: " + e.getMessage());
        }
        return false;
    }
}


