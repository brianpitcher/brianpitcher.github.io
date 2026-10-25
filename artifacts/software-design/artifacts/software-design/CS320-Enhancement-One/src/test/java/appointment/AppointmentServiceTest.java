// Brian Pitcher
// CS-499

package appointment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Date futureDate;

    @BeforeEach
    public void setUp() {

        // Create a fresh service before each test
        appointmentService =
                new AppointmentService();

        // Create a date one day in the future for the tests
        futureDate =
                new Date(
                        System.currentTimeMillis()
                                + 86400000
                );
    }

    @Test
    public void testAddAppointment() {

        // Create a valid appointment
        Appointment appointment =
                new Appointment(
                        "A1001",
                        futureDate,
                        "Business meeting"
                );

        // Add the appointment to the service
        appointmentService.addAppointment(
                appointment
        );

        // Check that the appointment was stored correctly
        assertEquals(
                appointment,
                appointmentService
                        .getAppointment("A1001")
        );
    }


    @Test
    public void testDuplicateAppointment() {

        Appointment appointment =
                new Appointment(
                        "A1001",
                        futureDate,
                        "Business meeting"
                );

        appointmentService.addAppointment(
                appointment
        );

        // Adding the same appointment ID again should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService
                        .addAppointment(appointment)
        );
    }

    @Test
    public void testDeleteAppointment() {

        Appointment appointment =
                new Appointment(
                        "A1001",
                        futureDate,
                        "Business meeting"
                );

        appointmentService.addAppointment(
                appointment
        );

        // Delete the appointment
        appointmentService.deleteAppointment(
                "A1001"
        );

        // The deleted appointment should no longer be found
        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService
                        .getAppointment("A1001")
        );
    }

    @Test
    public void testDeleteNonExistentAppointment() {

        // deleting an appointment that does not exist should cause an error.
        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService
                        .deleteAppointment("A9999")
        );
    }

    @Test
    public void testUpdateAppointment() {

        // Create and add the original appointment
        Appointment originalAppointment =
                new Appointment(
                        "A1001",
                        futureDate,
                        "Original description"
                );

        appointmentService.addAppointment(
                originalAppointment
        );

        // Create a new date two days in the future
        Date newDate =
                new Date(
                        System.currentTimeMillis()
                                + 172800000
                );

        // Create the updated appointment using the same ID
        Appointment updatedAppointment =
                new Appointment(
                        "A1001",
                        newDate,
                        "Updated description"
                );

        // Replace the original appointment
        appointmentService.updateAppointment(
                "A1001",
                updatedAppointment
        );

        // Check that the updated appointment was saved.
        assertEquals(
                updatedAppointment,
                appointmentService
                        .getAppointment("A1001")
        );
    }

    @Test
    public void testUpdateNonExistentAppointment() {

        Appointment appointment =
                new Appointment(
                        "A9999",
                        futureDate,
                        "Test appointment"
                );

        // Updating an appointment that does not exist should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService
                        .updateAppointment(
                                "A9999",
                                appointment
                        )
        );
    }

    @Test
    public void testUpdateWithMismatchedId() {

        Appointment originalAppointment =
                new Appointment(
                        "A1001",
                        futureDate,
                        "Original description"
                );

        appointmentService.addAppointment(
                originalAppointment
        );

        // Create an appointment with a different ID
        Appointment wrongAppointment =
                new Appointment(
                        "A2000",
                        futureDate,
                        "Wrong ID"
                );

        // The ID's must match when updating an appointment
        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService
                        .updateAppointment(
                                "A1001",
                                wrongAppointment
                        )
        );
    }

}

