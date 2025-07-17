
package com.gui;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import model.Feedback;
import controller.FeedbackController;
import com.database.FeedbackDAO;
import model.Feedback;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FeedBackSubmission extends javax.swing.JPanel {

    
    private void loadFeedback() {
    FeedbackDAO dao = new FeedbackDAO();
    List<Feedback> feedbackList = dao.getAllFeedback();

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear old rows

    for (Feedback fb : feedbackList) {
        Object[] row = {
            fb.getComment(),  // Column 0: Comment
            fb.getRating(),   // Column 1: Rating
            fb.getId()        // Column 2: ID
        };
        model.addRow(row);
    }
}

    public FeedBackSubmission() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textComment = new javax.swing.JTextField();
        submitBt = new javax.swing.JButton();
        editBt = new javax.swing.JButton();
        delBt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label2 = new java.awt.Label();
        textRating = new javax.swing.JTextField();
        IdText = new javax.swing.JTextField();
        label3 = new java.awt.Label();

        setBackground(new java.awt.Color(30, 30, 30));
        setPreferredSize(new java.awt.Dimension(895, 834));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Feedback Submission");

        textComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCommentActionPerformed(evt);
            }
        });

        submitBt.setBackground(new java.awt.Color(104, 204, 104));
        submitBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        submitBt.setForeground(new java.awt.Color(255, 255, 255));
        submitBt.setText("Submit Feedback");
        submitBt.setBorderPainted(false);
        submitBt.setPreferredSize(new java.awt.Dimension(97, 50));
        submitBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtActionPerformed(evt);
            }
        });

        editBt.setBackground(new java.awt.Color(57, 99, 237));
        editBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        editBt.setForeground(new java.awt.Color(255, 255, 255));
        editBt.setText("Edit Entry");
        editBt.setBorderPainted(false);
        editBt.setPreferredSize(new java.awt.Dimension(0, 50));
        editBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtActionPerformed(evt);
            }
        });

        delBt.setBackground(new java.awt.Color(211, 57, 49));
        delBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        delBt.setForeground(new java.awt.Color(255, 255, 255));
        delBt.setText("Delete Entry");
        delBt.setBorderPainted(false);
        delBt.setPreferredSize(new java.awt.Dimension(0, 50));
        delBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Write us a Comment...");

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comment", "Rating", "ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        label2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Rate our Services on a scale of 1-5");

        textRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRatingActionPerformed(evt);
            }
        });

        IdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTextActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("ID of Comment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 94, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(editBt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delBt, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textComment)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                                .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdText, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textComment, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdText, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtActionPerformed
        // Get values from form fields
String comment = textComment.getText().trim();
String counselorName = textRating.getText().trim();
int rating;

// Validate rating input
try {
    rating = Integer.parseInt(textRating.getText().trim());
    if (rating < 1 || rating > 5) {
        JOptionPane.showMessageDialog(this, "Rating must be between 1 and 5.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Please enter a valid number for rating (1–5).", "Input Error", JOptionPane.WARNING_MESSAGE);
    return;
}

// Validate other fields
if (comment.isEmpty() || counselorName.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
    return;
}

// Create Feedback object
Feedback fb = new Feedback();
fb.setComment(comment);
fb.setRating(rating);

// Save using DAO
FeedbackDAO dao = new FeedbackDAO();
boolean success = dao.insertFeedback(fb);

// Handle result
if (success) {
    JOptionPane.showMessageDialog(this, " Feedback submitted successfully!");
    textComment.setText("");
    textRating.setText("");
    loadFeedback();  // Reloads table if you have it
} else {
    JOptionPane.showMessageDialog(this, " Failed to submit feedback.", "Error", JOptionPane.ERROR_MESSAGE);
}
     
    }//GEN-LAST:event_submitBtActionPerformed
private int selectedId = -1; // declare at class level

    private void editBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtActionPerformed
        if (selectedId == -1) {
        JOptionPane.showMessageDialog(this, "Please select a feedback entry to edit.");
        return;
    }

    String comment = textComment.getText().trim();
    int rating;
    try {
        rating = Integer.parseInt(textRating.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid rating. Enter a number.");
        return;
    }

    Feedback fb = new Feedback();
    fb.setId(selectedId);
    fb.setComment(comment);
    fb.setRating(rating);

    FeedbackDAO dao = new FeedbackDAO();
    if (dao.updateFeedback(fb)) {
        JOptionPane.showMessageDialog(this, "Feedback updated.");
        loadFeedback(); // refresh table
        textComment.setText("");
        textRating.setText("");
        IdText.setText(""); // optional if showing ID
        selectedId = -1;
    } else {
        JOptionPane.showMessageDialog(this, "Update failed.");
    }
    }//GEN-LAST:event_editBtActionPerformed

    private void delBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtActionPerformed
         String idStr = IdText.getText().trim();

    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a feedback entry to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    try {
        int id = Integer.parseInt(idStr);  // convert string to int safely
        FeedbackDAO dao = new FeedbackDAO();
        if (dao.deleteFeedback(id)) {
            JOptionPane.showMessageDialog(this, "Feedback deleted.");
            loadFeedback(); // refresh the table
            IdText.setText("");  // clear the ID field
            textComment.setText("");
            textRating.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Delete failed.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid ID format.");
    }
    }//GEN-LAST:event_delBtActionPerformed

    private void textCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCommentActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
    if (row != -1) {
        String comment = jTable1.getValueAt(row, 0).toString(); // Comment column
        String rating = jTable1.getValueAt(row, 1).toString();  // Rating column
        String idStr = jTable1.getValueAt(row, 2).toString();   // ID column

        try {
            selectedId = Integer.parseInt(idStr); // store selected ID
            textComment.setText(comment);
            textRating.setText(rating);
            IdText.setText(idStr); // optional: show ID in textbox
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID in selected row.");
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void textRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRatingActionPerformed

    private void IdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdText;
    private javax.swing.JButton delBt;
    private javax.swing.JButton editBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JButton submitBt;
    private javax.swing.JTextField textComment;
    private javax.swing.JTextField textRating;
    // End of variables declaration//GEN-END:variables
}
