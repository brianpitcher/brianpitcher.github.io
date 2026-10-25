// Brian Pitcher
// 2/16/2025

package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // A HashMap to store appointments using their ID as the key
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        // Make sure that the appointment ID is unique
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        // Store the appointment in the HashMap
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Method to delete an appointment by its ID
    public void deleteAppointment(String appointmentId) {
        // Check if the appointment ID exists before deleting
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        // Remove the appointment from the HashMap
        appointments.remove(appointmentId);
    }

    // Method to update an existing appointment by replacing it with a new one
    public void updateAppointment(String appointmentId, Appointment newAppointment) {
        // Make sure the appointment ID exists before updating
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        // Replace the old appointment with the new one
        appointments.put(appointmentId, newAppointment);
    }

    // Method to retrieve an appointment by its ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
