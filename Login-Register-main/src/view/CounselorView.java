/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CounselorController;
import model.Counselor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author JANE
 */
public class CounselorView extends JPanel{
    
     // Controller reference
    private final CounselorController controller;
    //generated components from counselor GUI form
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
     private javax.swing.JTable jTable1;
    
      public void setAddButton(JButton button) {
        this.jButton1 = button;
    }

    public void setEditButton(JButton button) {
        this.jButton2 = button;
    }

    public void setDeleteButton(JButton button) {
        this.jButton3 = button;
    }

    public void setEmpIdField(JTextField field) {
        this.jTextField1 = field;
    }

    public void setNameField(JTextField field) {
        this.jTextField2 = field;
    }

    public void setSpecializationField(JTextField field) {
        this.jTextField3 = field;
    }

    public void setAvailabilityField(JTextField field) {
        this.jTextField4 = field;
    }

    public void setCounselorTable(JTable table) {
        this.jTable1 = table;
    }
     public CounselorView() {
       
        this.controller = new CounselorController();
        setupControllers();
        loadTableData();
    }
     
     private void setupControllers() {
        // Add button action
        jButton1.addActionListener(e -> {
            Counselor counselor = createCounselorFromInput();
            if (counselor != null && controller.addCounselor(counselor)) {
                JOptionPane.showMessageDialog(this, "Added successfully!");
                refreshTable();
                clearFields();
            }
        });
        
         // Edit button action
        jButton2.addActionListener(e -> {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Select a counselor first!");
                return;
            }
            
            Counselor counselor = createCounselorFromInput();
            if (counselor != null && controller.updateCounselor(counselor)) {
                JOptionPane.showMessageDialog(this, "Updated successfully!");
                refreshTable();
            }
        });
        
         // Delete button action
        jButton3.addActionListener(e -> {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Select a counselor first!");
                return;
            }
            
            String empId = (String) jTable1.getValueAt(selectedRow, 0);
            if (controller.deleteCounselor(empId)) {
                JOptionPane.showMessageDialog(this, "Deleted successfully!");
                refreshTable();
                clearFields();
            }
        });
        
         // Table selection listener
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                int selectedRow = jTable1.getSelectedRow();
                jTextField1.setText((String) jTable1.getValueAt(selectedRow, 0));
                jTextField2.setText((String) jTable1.getValueAt(selectedRow, 1));
                jTextField3.setText((String) jTable1.getValueAt(selectedRow, 2));
                jTextField4.setText((String) jTable1.getValueAt(selectedRow, 3));
            }
        });
    }

    private Counselor createCounselorFromInput() {
        String empId = jTextField1.getText().trim();
        String name = jTextField2.getText().trim();
        String specialization = jTextField3.getText().trim();
        String availability = jTextField4.getText().trim();

        if (empId.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee ID and Name are required!");
            return null;
        }

        return new Counselor(empId, name, specialization, availability);
    }
    
      private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data
        
        List<Counselor> counselors = controller.getAllCounselors();
        for (Counselor c : counselors) {
            model.addRow(new Object[]{
                c.getEmpId(),
                c.getName(),
                c.getSpecialization(),
                c.getAvailability()
            });
        }
    }

    private void refreshTable() {
        loadTableData();
    }
    public void initializeView() {
        setupControllers();
        loadTableData();
    }

    public void refreshView() {
        loadTableData();
    }

    private void clearFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }
}
