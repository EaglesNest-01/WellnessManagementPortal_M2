package com.database;

import model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    // INSERT new feedback
    public boolean insertFeedback(Feedback fb) {
        String sql = "INSERT INTO APP.FEEDBACK (COMMENT, RATING) VALUES (?, ?)";
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fb.getComment());
            ps.setInt(2, fb.getRating());

            int rows = ps.executeUpdate();
            System.out.println("Inserted feedback, rows affected: " + rows);
            return rows > 0;
        } catch (Exception e) {
            System.err.println("Insert error: " + e.getMessage());
            return false;
        }
    }

    // READ all feedback
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM APP.FEEDBACK";
        try (Connection conn = DerbyConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Feedback fb = new Feedback();
                fb.setId(rs.getInt("ID"));
                fb.setComment(rs.getString("COMMENT"));
                fb.setRating(rs.getInt("RATING"));
                feedbackList.add(fb);
            }
            System.out.println("Loaded " + feedbackList.size() + " feedback entries.");
        } catch (Exception e) {
            System.err.println("Fetch error: " + e.getMessage());
        }
        return feedbackList;
    }

    // UPDATE feedback
    public boolean updateFeedback(Feedback fb) {
        String sql = "UPDATE APP.FEEDBACK SET COMMENT = ?, RATING = ? WHERE ID = ?";
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fb.getComment());
            ps.setInt(2, fb.getRating());
            ps.setInt(3, fb.getId());

            int rows = ps.executeUpdate();
            System.out.println("Updated feedback ID " + fb.getId() + ", rows affected: " + rows);
            return rows > 0;
        } catch (Exception e) {
            System.err.println("Update error: " + e.getMessage());
            return false;
        }
    }

    // DELETE feedback
    public boolean deleteFeedback(int id) {
        String sql = "DELETE FROM APP.FEEDBACK WHERE ID = ?";
        try (Connection conn = DerbyConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Deleted feedback ID " + id + ", rows affected: " + rows);
            return rows > 0;
        } catch (Exception e) {
            System.err.println("Delete error: " + e.getMessage());
            return false;
        }
    }
}