package controller;

import com.database.AppointmentDAO;
import model.Appointment;
import java.util.List;

public class AppointmentController {

    // ✅ Create new appointment using object
    public boolean createAppointment(Appointment appointment) {
        return AppointmentDAO.insertAppointment(appointment);
    }

    // ✅ Read all appointments
    public List<Appointment> getAllAppointments() {
        return AppointmentDAO.getAllAppointments();
    }

    // ✅ Update appointment using the full object (must contain valid ID)
    public boolean updateAppointment(Appointment appointment) {
        return AppointmentDAO.updateAppointment(appointment);
    }

    // ✅ Delete appointment using ID
    public boolean deleteAppointment(int id) {
        return AppointmentDAO.deleteAppointment(id);
    }
}