/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author JANE
 */
public class FeedbackController {
    
//    // Create feedback
//    public boolean submitFeedback(Feedback feedback) {
//        String sql = "INSERT INTO feedback (student_number, counselor_id, rating, comments, feedback_date) " +
//                     "VALUES (?, ?, ?, ?, ?)";
//        
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, feedback.getStudentNumber());
//            pstmt.setInt(2, feedback.getCounselorId());
//            pstmt.setInt(3, feedback.getRating());
//            pstmt.setString(4, feedback.getComments());
//            pstmt.setDate(5, new Date(System.currentTimeMillis()));
//            
//            return pstmt.executeUpdate() > 0;
//        } catch (SQLException | IOException e) {
//            System.err.println("Error submitting feedback: " + e.getMessage());
//            return false;
//        }
//    }
//    
//    // Read feedback
//    public List<Feedback> getFeedbackByStudent(String studentNumber) {
//        List<Feedback> feedbackList = new ArrayList<>();
//        String sql = "SELECT * FROM feedback WHERE student_number = ?";
//        
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, studentNumber);
//            ResultSet rs = pstmt.executeQuery();
//            
//            while (rs.next()) {
//                Feedback feedback = new Feedback();
//                feedback.setId(rs.getInt("id"));
//                feedback.setStudentNumber(rs.getString("student_number"));
//                feedback.setCounselorId(rs.getInt("counselor_id"));
//                feedback.setRating(rs.getInt("rating"));
//                feedback.setComments(rs.getString("comments"));
//                feedback.setFeedbackDate(rs.getDate("feedback_date"));
//                feedbackList.add(feedback);
//            }
//        } catch (SQLException | IOException e) {
//            System.err.println("Error fetching feedback: " + e.getMessage());
//        }
//        return feedbackList;
//    }
    

    
    
    
    
}
