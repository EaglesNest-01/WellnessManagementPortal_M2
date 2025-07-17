package com.gui;

import com.database.AppointmentDAO;
import controller.AppointmentController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Appointment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class AppointmentManagement extends javax.swing.JPanel {

    private AppointmentController controller = new AppointmentController();
    private DefaultTableModel tableModel;

    public AppointmentManagement() {
        initComponents();
        initializeTableModel();
        loadAppointments();
    }

    private void initializeTableModel() {
    tableModel = new DefaultTableModel(
        new Object[][]{},
        new String[]{"ID", "Counsellor", "Date", "Time", "Reason"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // All cells are non-editable
        }
    };
    jTable1.setModel(tableModel);

    // 🟢 Do NOT hide the ID column anymore
    // (No need to change column size)
}

    private void loadAppointments() {
        try {
            tableModel.setRowCount(0); // Clear existing data

            for (Appointment app : controller.getAllAppointments()) {
                tableModel.addRow(new Object[]{
                    app.getId(),
                    app.getCounsellor(),
                    app.getDate(),
                    app.getTime(),
                    app.getReason()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading appointments: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        counsellorText.setText("");
        timeText.setText("");
        reasonText.setText("");
        appIdText.setText("");
        jDateChooser1.setDate(null);
        jTable1.clearSelection();
    }

    private boolean counselorExists(String empId) {
        try {
            List<model.Counselor> counselors = com.database.CounselorDAO.getAllCounselors();
            for (model.Counselor c : counselors) {
                if (c.getEmpId().equalsIgnoreCase(empId)) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error checking counselor: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        counsellorText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        reasonText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        reschedulebt = new javax.swing.JButton();
        cancelAppointmentbt = new javax.swing.JButton();
        bookAppointmentbt = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        javax.swing.JButton refreshBt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        appIdText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(30, 30, 30));
        setPreferredSize(new java.awt.Dimension(887, 834));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appointment Management");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Time:");

        counsellorText.setPreferredSize(new java.awt.Dimension(71, 35));
        counsellorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counsellorTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Counsellor ID:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");

        timeText.setPreferredSize(new java.awt.Dimension(71, 35));
        timeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTextActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Reason:");

        reasonText.setPreferredSize(new java.awt.Dimension(71, 35));
        reasonText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reasonTextActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(26, 26, 26));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Counsellor", "Date", "Time", "Reason", "Appointment ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        reschedulebt.setBackground(new java.awt.Color(57, 99, 237));
        reschedulebt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        reschedulebt.setForeground(new java.awt.Color(255, 255, 255));
        reschedulebt.setText("Reschedule");
        reschedulebt.setBorderPainted(false);
        reschedulebt.setPreferredSize(new java.awt.Dimension(0, 50));
        reschedulebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reschedulebtActionPerformed(evt);
            }
        });

        cancelAppointmentbt.setBackground(new java.awt.Color(211, 57, 49));
        cancelAppointmentbt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        cancelAppointmentbt.setForeground(new java.awt.Color(255, 255, 255));
        cancelAppointmentbt.setText("Cancel Appointment");
        cancelAppointmentbt.setBorderPainted(false);
        cancelAppointmentbt.setPreferredSize(new java.awt.Dimension(0, 50));
        cancelAppointmentbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAppointmentbtActionPerformed(evt);
            }
        });

        bookAppointmentbt.setBackground(new java.awt.Color(104, 204, 104));
        bookAppointmentbt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        bookAppointmentbt.setForeground(new java.awt.Color(255, 255, 255));
        bookAppointmentbt.setText("Book Appointment");
        bookAppointmentbt.setBorderPainted(false);
        bookAppointmentbt.setPreferredSize(new java.awt.Dimension(0, 50));
        bookAppointmentbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAppointmentbtActionPerformed(evt);
            }
        });

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));

        refreshBt.setBackground(new java.awt.Color(128, 0, 128));
        refreshBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        refreshBt.setForeground(new java.awt.Color(255, 255, 255));
        refreshBt.setText("Refresh table");
        refreshBt.setBorderPainted(false);
        refreshBt.setPreferredSize(new java.awt.Dimension(0, 50));
        refreshBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Appointment ID:");

        appIdText.setPreferredSize(new java.awt.Dimension(71, 35));
        appIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appIdTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(counsellorText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reasonText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(appIdText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshBt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookAppointmentbt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reschedulebt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelAppointmentbt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(counsellorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reasonText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reschedulebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelAppointmentbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookAppointmentbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reschedulebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reschedulebtActionPerformed
   int selectedRow = jTable1.getSelectedRow();
if (selectedRow < 0) {
    JOptionPane.showMessageDialog(this, "Please select an appointment to reschedule", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    // Get ID from column 0
    Object idObj = jTable1.getValueAt(selectedRow, 0);
    if (idObj == null) throw new Exception("Appointment ID is missing!");
    int id = Integer.parseInt(idObj.toString());

    // Get and validate counselor ID
    String counselorStr = counsellorText.getText().trim();
    if (counselorStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Counselor ID cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int counselorId;
    try {
        counselorId = Integer.parseInt(counselorStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Counselor ID must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get other fields
    String reason = reasonText.getText().trim();
    String time = timeText.getText().trim();
    java.util.Date selectedDate = jDateChooser1.getDate();

    if (reason.isEmpty() || time.isEmpty() || selectedDate == null) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Time validation
    java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH:mm");
    java.util.Date parsedTime = timeFormat.parse(time);
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.setTime(parsedTime);
    int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
    if (hour < 7 || hour > 17) {
        JOptionPane.showMessageDialog(this, "Time must be between 07:00 and 17:00.", "Invalid Time", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);

    // Conflict check
    for (Appointment a : controller.getAllAppointments()) {
        if (a.getId() == id) continue;
        if (a.getDate().equals(date)) {
            java.util.Date otherTime = timeFormat.parse(a.getTime());
            if (Math.abs(parsedTime.getTime() - otherTime.getTime()) < 3600000) {
                JOptionPane.showMessageDialog(this, "Conflict: Another appointment is within 1 hour.", "Conflict", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }

    // ✅ Create updated appointment
    Appointment updated = new Appointment(id, String.valueOf(counselorId), date, time, reason);
    if (controller.updateAppointment(updated)) {
        JOptionPane.showMessageDialog(this, "Appointment updated!");
        clearForm();
        loadAppointments();
    } else {
        JOptionPane.showMessageDialog(this, "Update failed.", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
}
    }//GEN-LAST:event_reschedulebtActionPerformed

    private void cancelAppointmentbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAppointmentbtActionPerformed
int selectedRow = jTable1.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an appointment to cancel", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to cancel this appointment?",
        "Confirm Cancellation",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            int id = (int) jTable1.getValueAt(selectedRow, 0);  // ID column index

            boolean success = controller.deleteAppointment(id); // Use the int ID here
            if (success) {
                JOptionPane.showMessageDialog(this, "Appointment cancelled successfully!");
                clearForm();
                loadAppointments();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to cancel appointment", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_cancelAppointmentbtActionPerformed

    private void bookAppointmentbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAppointmentbtActionPerformed
       
// Validate inputs first
if (!validateInputs() || !validateDateTime()) {
    return;
}

try {
    String counsellor = counsellorText.getText().trim();
    String time = timeText.getText().trim();
    String reason = reasonText.getText().trim();

    // Format date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(jDateChooser1.getDate());

    // Check empty fields
    if (counsellor.isEmpty() || reason.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Counsellor and Reason fields are required!",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if counselor exists
    if (!counselorExists(counsellor)) {
        JOptionPane.showMessageDialog(this,
            "Counselor with ID '" + counsellor + "' does not exist.\nPlease create the counselor first.",
            "Missing Counselor",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Check time bounds (07:00 to 17:00)
    int hour = Integer.parseInt(time.split(":")[0]);
    if (hour < 7 || hour >= 17) {
        JOptionPane.showMessageDialog(this,
            "Time must be between 07:00 and 17:00.",
            "Time Constraint",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Conflict check
    List<Appointment> appointments = controller.getAllAppointments();
    for (Appointment a : appointments) {
        if (a.getCounsellor().equalsIgnoreCase(counsellor) && a.getDate().equals(date)) {
            int existingHour = Integer.parseInt(a.getTime().split(":")[0]);
            int requestedHour = Integer.parseInt(time.split(":")[0]);
            if (Math.abs(existingHour - requestedHour) < 1) {
                JOptionPane.showMessageDialog(this,
                    "Booking conflict: Another appointment exists at or near this time for this counselor.\nPlease choose a time at least 1 hour apart.",
                    "Conflict",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }

    // ✅ Use user-input ID if valid, otherwise generate
    int id;
    try {
        id = Integer.parseInt(appIdText.getText().trim());
    } catch (NumberFormatException e) {
        id = (int)(Math.random() * 9000 + 100);  // fallback random ID
        appIdText.setText(String.valueOf(id));   // update the field
    }

    // Create and save appointment
    Appointment appointment = new Appointment(id, counsellor, date, time, reason);

    if (controller.createAppointment(appointment)) {
        JOptionPane.showMessageDialog(this, 
            "Appointment booked successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
        clearForm();
        loadAppointments();
    } else {
        JOptionPane.showMessageDialog(this, 
            "Failed to book appointment. Please try again.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, 
        "Error: " + e.getMessage(),
        "System Error",
        JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
    }//GEN-LAST:event_bookAppointmentbtActionPerformed
private boolean validateInputs() {
    if (counsellorText.getText().trim().isEmpty() ||
        timeText.getText().trim().isEmpty() ||
        reasonText.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "All fields are required!", 
            "Validation Error", 
            JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}
    private void counsellorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counsellorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_counsellorTextActionPerformed

    private void reasonTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reasonTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reasonTextActionPerformed

    private void timeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeTextActionPerformed

    private void refreshBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtActionPerformed
try {
        // Clear the table first
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Reload all appointments from database
        List<Appointment> appointments = controller.getAllAppointments();

        for (Appointment app : appointments) {
            model.addRow(new Object[]{
                app.getId(),
                app.getCounsellor(),
                app.getDate(),
                app.getTime(),
                app.getReason()
            });
        }

        if (appointments.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No appointments found in the database.");
        } else {
            JOptionPane.showMessageDialog(this, "Appointments table refreshed.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Failed to refresh appointments: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_refreshBtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     int selectedRow = jTable1.getSelectedRow();
if (selectedRow >= 0) {
    try {
        // Get values using correct column indices
        String idStr = jTable1.getValueAt(selectedRow, 0).toString(); // ID is column 0
        int id;
        try {
            id = Integer.parseInt(idStr); // ✅ Safe conversion
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID: " + idStr, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String counselor = jTable1.getValueAt(selectedRow, 1).toString(); // Counsellor
        String dateStr = jTable1.getValueAt(selectedRow, 2).toString();   // Date
        String time = jTable1.getValueAt(selectedRow, 3).toString();     // Time
        String reason = jTable1.getValueAt(selectedRow, 4).toString();   // Reason

        // Set form values
        appIdText.setText(String.valueOf(id));
        counsellorText.setText(counselor);
        timeText.setText(time);
        reasonText.setText(reason);

        // Parse and set the date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);
        jDateChooser1.setDate(date);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error loading appointment details: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }//GEN-LAST:event_jTable1MouseClicked

    private void appIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appIdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appIdTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appIdText;
    private javax.swing.JButton bookAppointmentbt;
    private javax.swing.JButton cancelAppointmentbt;
    private javax.swing.JTextField counsellorText;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField reasonText;
    private javax.swing.JButton reschedulebt;
    private javax.swing.JTextField timeText;
    // End of variables declaration//GEN-END:variables

  private boolean validateDateTime() {
    try {
        // Validate date from JDateChooser
        java.util.Date selectedDate = jDateChooser1.getDate();
        if (selectedDate == null) {
            throw new IllegalArgumentException("Please select a valid date.");
        }

        // You can convert the date if needed like this:
        String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        System.out.println("Selected Date: " + formattedDate); // optional log

        // Validate time in HH:MM (24-hour format)
        String time = timeText.getText().trim();
        if (!time.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            throw new IllegalArgumentException("Time must be in 24-hour HH:MM format (e.g. 09:30 or 14:45).");
        }

        return true;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
}
