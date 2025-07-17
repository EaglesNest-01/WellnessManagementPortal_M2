package com.database;

import model.Counselor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CounselorDAO {

    public static boolean insertCounselor(Counselor counselor) {
        String sql = "INSERT INTO COUNSELORS (EMP_ID, NAME, SPECIALIZATION, AVAILABILITY) VALUES (?, ?, ?, ?)";

        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, counselor.getEmpId());
            ps.setString(2, counselor.getName());
            ps.setString(3, counselor.getSpecialization());
            ps.setString(4, counselor.getAvailability());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Insert Counselor Error: " + e.getMessage());
            return false;
        }
    }

    public static List<Counselor> getAllCounselors() {
        List<Counselor> list = new ArrayList<>();
        String sql = "SELECT * FROM COUNSELORS";

        try (Connection conn = DerbyConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Counselor c = new Counselor(
                    rs.getString("EMP_ID"),
                    rs.getString("NAME"),
                    rs.getString("SPECIALIZATION"),
                    rs.getString("AVAILABILITY")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Fetch Counselors Error: " + e.getMessage());
        }

        return list;
    }

    public static boolean updateCounselor(Counselor counselor) {
        String sql = "UPDATE COUNSELORS SET NAME=?, SPECIALIZATION=?, AVAILABILITY=? WHERE EMP_ID=?";

        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, counselor.getName());
            ps.setString(2, counselor.getSpecialization());
            ps.setString(3, counselor.getAvailability());
            ps.setString(4, counselor.getEmpId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update Counselor Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteCounselor(String empId) {
        String sql = "DELETE FROM COUNSELORS WHERE EMP_ID=?";

        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete Counselor Error: " + e.getMessage());
            return false;
        }
    }
}
