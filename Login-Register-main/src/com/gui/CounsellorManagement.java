/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gui;
import model.Counselor;
import com.database.CounselorDAO;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
public class CounsellorManagement extends javax.swing.JPanel {

    public CounsellorManagement() {
        initComponents();
        
    }
    private void clearForm() {
    idText.setText("");
    nameText.setText("");
    specialText.setText("");
    avaibilityText.setText("");
    jTable1.clearSelection();  // unselect any row
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        javax.swing.JButton deleteBt = new javax.swing.JButton();
        javax.swing.JButton editBt = new javax.swing.JButton();
        javax.swing.JButton addBt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        javax.swing.JButton refreshBt = new javax.swing.JButton();
        avaibilityText = new javax.swing.JTextField();
        idText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        specialText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Counsellor Management");

        jTable1.setBackground(new java.awt.Color(16, 16, 16));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp_ID", "Name", "Specialization", "Availability"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        deleteBt.setBackground(new java.awt.Color(211, 57, 49));
        deleteBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        deleteBt.setForeground(new java.awt.Color(255, 255, 255));
        deleteBt.setText("Delete Information");
        deleteBt.setBorderPainted(false);
        deleteBt.setPreferredSize(new java.awt.Dimension(0, 50));
        deleteBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtActionPerformed(evt);
            }
        });

        editBt.setBackground(new java.awt.Color(57, 99, 237));
        editBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        editBt.setForeground(new java.awt.Color(255, 255, 255));
        editBt.setText("Edit Information");
        editBt.setBorderPainted(false);
        editBt.setPreferredSize(new java.awt.Dimension(0, 50));
        editBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtActionPerformed(evt);
            }
        });

        addBt.setBackground(new java.awt.Color(104, 204, 104));
        addBt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        addBt.setForeground(new java.awt.Color(255, 255, 255));
        addBt.setText("Add Counsellor");
        addBt.setBorderPainted(false);
        addBt.setPreferredSize(new java.awt.Dimension(0, 50));
        addBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Specialization:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Availability:");

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

        avaibilityText.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshBt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(specialText, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avaibilityText, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avaibilityText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtActionPerformed
        
    String empId = idText.getText().trim();
    if (empId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Employee ID to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this counselor?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    boolean result = CounselorDAO.deleteCounselor(empId);

    if (result) {
        JOptionPane.showMessageDialog(this, "Counselor deleted successfully.");
        refreshBtActionPerformed(null);
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, "Delete failed. EMP_ID may not exist.");
    }
    }//GEN-LAST:event_deleteBtActionPerformed

    private void editBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtActionPerformed
    String empId = idText.getText().trim();
    String name = nameText.getText().trim();
    String specialization = specialText.getText().trim();
    String availability = avaibilityText.getText().trim();

    if (empId.isEmpty() || name.isEmpty() || specialization.isEmpty() || availability.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in to update.");
        return;
    }

    Counselor updated = new Counselor(empId, name, specialization, availability);
    boolean result = CounselorDAO.updateCounselor(updated);

    if (result) {
        JOptionPane.showMessageDialog(this, "Counselor updated successfully.");
        refreshBtActionPerformed(null);
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, "Update failed. EMP_ID may not exist.");
    }
    
    }//GEN-LAST:event_editBtActionPerformed

    private void addBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtActionPerformed
// 1. Get text from fields
    String empId = idText.getText().trim();
    String name = nameText.getText().trim();
    String specialization = specialText.getText().trim();
    String availability = avaibilityText.getText().trim();

    // 2. Validate
    if (empId.isEmpty() || name.isEmpty() || specialization.isEmpty() || availability.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in!");
        return;
    }

    // 3. Create Counselor object
    Counselor counselor = new Counselor(empId, name, specialization, availability);

    // 4. Insert into DB using DAO
    boolean inserted = CounselorDAO.insertCounselor(counselor);

    // 5. Show result + refresh
    if (inserted) {
        JOptionPane.showMessageDialog(this, "Counselor added successfully.");
        refreshBtActionPerformed(null);
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add counselor. Maybe EMP_ID already exists?");
    }
    }//GEN-LAST:event_addBtActionPerformed

    private void refreshBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtActionPerformed
// Get the table model
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear previous rows

    // Fetch all counselors from the DB
    List<Counselor> counselors = com.database.CounselorDAO.getAllCounselors();

    // Loop through list and populate the table
    for (Counselor c : counselors) {
        model.addRow(new Object[]{
            c.getEmpId(),
            c.getName(),
            c.getSpecialization(),
            c.getAvailability()
        });
    }

    if (counselors.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No counselors found in the database.");
    }
    }//GEN-LAST:event_refreshBtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        idText.setText(jTable1.getValueAt(selectedRow, 0).toString());
        nameText.setText(jTable1.getValueAt(selectedRow, 1).toString());
        specialText.setText(jTable1.getValueAt(selectedRow, 2).toString());
        avaibilityText.setText(jTable1.getValueAt(selectedRow, 3).toString());
    }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField avaibilityText;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField specialText;
    // End of variables declaration//GEN-END:variables
}
