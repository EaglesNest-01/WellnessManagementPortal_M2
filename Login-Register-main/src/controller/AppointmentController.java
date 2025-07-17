package controller;

import com.database.AppointmentDAO;
import model.Appointment;
import java.util.List;

public class AppointmentController {
    
    public boolean createAppointment(Appointment appointment) {
        return AppointmentDAO.insertAppointment(appointment);
    }
    
    public List<Appointment> getAllAppointments() {
        return AppointmentDAO.getAllAppointments();
    }
    
    public boolean updateAppointment(Appointment appointment) {
        return AppointmentDAO.updateAppointment(appointment);
    }
    
    public boolean deleteAppointment(int id) {
        return AppointmentDAO.deleteAppointment(id);
    }
    
    public List<Appointment> getAppointmentsByStatus(String status) {
        // Implement if needed
        return null;
    }
}