package view;

import controller.FeedbackController;
import model.Feedback;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FeedbackView extends JPanel {

    private FeedbackController controller;
    private JTextArea commentArea;
    private JComboBox<Integer> ratingComboBox;
    private JTable feedbackTable;
    private DefaultTableModel tableModel;

    public FeedbackView() {
        controller = new FeedbackController();
        initializeUI();
        loadFeedback();
    }

    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Feedback Submission"));

        inputPanel.add(new JLabel("Write us a Comment..."));
        commentArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(commentArea));

        inputPanel.add(new JLabel("Rate our Services on a scale of 1-5"));
        ratingComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        inputPanel.add(ratingComboBox);

        // Buttons
        JButton submitBtn = new JButton("Submit Feedback");
        submitBtn.setBackground(Color.GREEN.darker());
        submitBtn.setForeground(Color.WHITE);
        submitBtn.addActionListener(e -> submitFeedback());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitBtn);

        // Table setup (Removed Counselor column)
        tableModel = new DefaultTableModel(new String[]{"ID", "Rating", "Comment"}, 0);
        feedbackTable = new JTable(tableModel);

        // Add components
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(feedbackTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void submitFeedback() {
        String comment = commentArea.getText().trim();
        int rating = (int) ratingComboBox.getSelectedItem();

        if (comment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a comment.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Feedback fb = new Feedback(0, comment, rating);  // ID = 0 (auto)
        if (controller.submitFeedback(fb)) {
            JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");
            commentArea.setText("");
            ratingComboBox.setSelectedIndex(0);
            loadFeedback();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit feedback.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadFeedback() {
        List<Feedback> allFeedback = controller.getAllFeedback();
        tableModel.setRowCount(0);
        for (Feedback fb : allFeedback) {
            tableModel.addRow(new Object[]{
                fb.getId(), fb.getRating(), fb.getComment()
            });
        }
    }
}