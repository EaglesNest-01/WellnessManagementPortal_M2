/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller; 


import model.Counselor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author JANE
 */


public class CounselorController {
    
    private Connection getConnection() throws SQLException {
    String url = "jdbc:derby:D:\\CODE\\WellnessManagementPortal_M2\\Database\\WellnessDB;create=true";
    String user = "admni";
    String password = "admin";
    return DriverManager.getConnection(url, user, password);
}
    public boolean addCounselor(Counselor counselor) {
        String sql = "INSERT INTO counselors (emp_id, name, specialization, availability) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, counselor.getEmpId());
            pstmt.setString(2, counselor.getName());
            pstmt.setString(3, counselor.getSpecialization());
            pstmt.setString(4, counselor.getAvailability());
            
                        return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding counselor: " + e.getMessage());
            return false;
        }
    } 
    
       // Read all counselors
    public List<Counselor> getAllCounselors() {
        List<Counselor> counselors = new ArrayList<>();
        String sql = "SELECT * FROM counselors";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Counselor counselor = new Counselor();
                counselor.setEmpId(rs.getString("emp_id"));
                counselor.setName(rs.getString("name"));
                counselor.setSpecialization(rs.getString("specialization"));
                counselor.setAvailability(rs.getString("availability"));
                counselors.add(counselor);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching counselors: " + e.getMessage());
        }
        return counselors;
    }
    
    public boolean updateCounselor(Counselor counselor) {
        String sql = "UPDATE counselors SET name = ?, specialization = ?, " +
                     "available_days = ?, available_time = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, counselor.getEmpId());
            pstmt.setString(2, counselor.getName());
            pstmt.setString(3, counselor.getSpecialization());
            pstmt.setString(4, counselor.getAvailability());
            
            
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating counselor: " + e.getMessage());
            return false;
        }
    }
       // Delete counselor
    public boolean deleteCounselor(int counselorId) {
        String sql = "DELETE FROM counselors WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, counselorId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting counselor: " + e.getMessage());
            return false;
        }
    }
}
