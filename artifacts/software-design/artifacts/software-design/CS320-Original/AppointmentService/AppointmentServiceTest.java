// Brian Pitcher
// 2/16/2025

package test;

import appointment.Appointment;
import appointment.AppointmentService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        // Initialize AppointmentService before each test
        appointmentService = new AppointmentService();
        // Set a future date for test appointments
        futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
    }

    @Test
    void testAddAppointment() {
        // Create and add a valid appointment
        Appointment appointment = new Appointment("A1001", futureDate, "Business meeting");
        appointmentService.addAppointment(appointment);

        // Verify that the appointment was added successfully
        assertEquals(appointment, appointmentService.getAppointment("A1001"));
    }

    @Test
    void testAddDuplicateAppointment() {
        // Create two appointments with the same ID
        Appointment appointment1 = new Appointment("A1002", futureDate, "Dentist visit");
        Appointment appointment2 = new Appointment("A1002", futureDate, "Duplicate ID test");

        // Add the first appointment successfully
        appointmentService.addAppointment(appointment1);

        // Attempt to add the duplicate appointment, expecting an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteAppointment() {
        // Create and add an appointment
        Appointment appointment = new Appointment("A1003", futureDate, "Haircut appointment");
        appointmentService.addAppointment(appointment);
        
        // Delete the appointment
        appointmentService.deleteAppointment("A1003");

        // Verify that the appointment is no longer available
        assertNull(appointmentService.getAppointment("A1003"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        // Attempt to delete a non-existent appointment, expecting an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("NonExistentID");
        });
    }

    @Test
    void testUpdateAppointment() {
        // Create and add an initial appointment
        Appointment oldAppointment = new Appointment("A1004", futureDate, "Gym session");
        appointmentService.addAppointment(oldAppointment);
        
        // Create a new appointment with updated details
        Date newDate = new Date(System.currentTimeMillis() + 172800000); // 2 days ahead
        Appointment newAppointment = new Appointment("A1004", newDate, "Updated gym session");

        // Update the existing appointment
        appointmentService.updateAppointment("A1004", newAppointment);

        // Verify that the appointment has been updated
        assertEquals(newAppointment, appointmentService.getAppointment("A1004"));
    }

    @Test
    void testUpdateNonExistentAppointment() {
        // Create an appointment that is not yet in the service
        Date newDate = new Date(System.currentTimeMillis() + 172800000);
        Appointment newAppointment = new Appointment("A2000", newDate, "Trying to update non-existent appointment");

        // Attempt to update a non-existent appointment, expecting an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointment("A2000", newAppointment);
        });
    }
}
