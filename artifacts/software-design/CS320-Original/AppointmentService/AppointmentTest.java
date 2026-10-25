// Brian Pitcher
// 2/16/2025

package test;

import appointment.Appointment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {

    @Test
    void testValidAppointmentCreation() {
        // Create a future date for the appointment
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
        // Create a valid appointment
        Appointment appointment = new Appointment("A12345", futureDate, "Doctor's appointment");

        // Verify that the appointment fields are correctly assigned
        assertEquals("A12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Test for null appointment ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Checkup");
        });

        // Test for appointment ID exceeding 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Checkup"); // 11 characters
        });
    }

    @Test
    void testInvalidAppointmentDate() {
        // Create a past date for testing
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past

        // Test for an appointment date that is in the past
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", pastDate, "Past appointment");
        });

        // Test for a null appointment date
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", null, "Null date");
        });
    }

    @Test
    void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Test for a null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", futureDate, null);
        });

        // Test for a description exceeding 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", futureDate, "This description is way too long and exceeds the fifty character limit.");
        });
    }
}
