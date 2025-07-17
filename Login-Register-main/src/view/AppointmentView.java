package view;

import controller.AppointmentController;
import model.Appointment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;

public class AppointmentView extends JPanel {
    private AppointmentController controller;
    private JComboBox<String> counselorComboBox;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField reasonField;
    private JTable appointmentTable;
    private DefaultTableModel tableModel;
    
    public AppointmentView() {
        this.controller = new AppointmentController();
        initializeUI();
        refreshAppointmentTable();
    }
    
    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Appointment Details"));
        
        inputPanel.add(new JLabel("Counselor:"));
        counselorComboBox = new JComboBox<>(new String[]{"Dr. Smith", "Dr. Johnson", "Dr. Williams"});
        inputPanel.add(counselorComboBox);
        
        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        inputPanel.add(dateField);
        
        inputPanel.add(new JLabel("Time (HH:MM):"));
        timeField = new JTextField();
        inputPanel.add(timeField);
        
        inputPanel.add(new JLabel("Reason:"));
        reasonField = new JTextField();
        inputPanel.add(reasonField);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton bookButton = new JButton("Book Appointment");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        
        // Appointment table
        String[] columnNames = {"ID", "Counselor", "Date", "Time", "Reason"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        appointmentTable = new JTable(tableModel);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add action listeners
        bookButton.addActionListener(this::bookAppointment);
        updateButton.addActionListener(this::updateAppointment);
        deleteButton.addActionListener(this::deleteAppointment);
        clearButton.addActionListener(e -> clearFields());
        
        appointmentTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = appointmentTable.getSelectedRow();
                if (selectedRow >= 0) {
                    fillFieldsFromTable(selectedRow);
                }
            }
        });
        
        buttonPanel.add(bookButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        
        // Add components to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(appointmentTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void bookAppointment(ActionEvent e) {
        String counsellor = (String) counselorComboBox.getSelectedItem();
        String date = dateField.getText();
        String time = timeField.getText();
        String reason = reasonField.getText();
        
        Appointment appointment = new Appointment(0, counsellor, date, time, reason);
        
        if (controller.createAppointment(appointment)) {
            JOptionPane.showMessageDialog(this, "Appointment booked successfully");
            clearFields();
            refreshAppointmentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to book appointment", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateAppointment(ActionEvent e) {
        int selectedRow = appointmentTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an appointment to update");
            return;
        }
        
        int id = (int) appointmentTable.getValueAt(selectedRow, 0);
        String counsellor = (String) counselorComboBox.getSelectedItem();
        String date = dateField.getText();
        String time = timeField.getText();
        String reason = reasonField.getText();
        
        Appointment appointment = new Appointment(id, counsellor, date, time, reason);
        
        if (controller.updateAppointment(appointment)) {
            JOptionPane.showMessageDialog(this, "Appointment updated successfully");
            clearFields();
            refreshAppointmentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update appointment", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteAppointment(ActionEvent e) {
        int selectedRow = appointmentTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an appointment to delete");
            return;
        }
        
        int id = (int) appointmentTable.getValueAt(selectedRow, 0);
        
        int confirm = JOptionPane.showConfirmDialog(
            this, 
            "Are you sure you want to delete this appointment?", 
            "Confirm Delete", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (controller.deleteAppointment(id)) {
                JOptionPane.showMessageDialog(this, "Appointment deleted successfully");
                clearFields();
                refreshAppointmentTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete appointment", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void refreshAppointmentTable() {
        tableModel.setRowCount(0);
        var appointments = controller.getAllAppointments();
        for (Appointment app : appointments) {
            tableModel.addRow(new Object[]{
                app.getId(),
                app.getCounsellor(),
                app.getDate(),
                app.getTime(),
                app.getReason()
            });
        }
    }
    
    private void fillFieldsFromTable(int selectedRow) {
        counselorComboBox.setSelectedItem(appointmentTable.getValueAt(selectedRow, 1));
        dateField.setText(appointmentTable.getValueAt(selectedRow, 2).toString());
        timeField.setText(appointmentTable.getValueAt(selectedRow, 3).toString());
        reasonField.setText(appointmentTable.getValueAt(selectedRow, 4).toString());
    }
    
    private void clearFields() {
        counselorComboBox.setSelectedIndex(0);
        dateField.setText("");
        timeField.setText("");
        reasonField.setText("");
        appointmentTable.clearSelection();
    }
}