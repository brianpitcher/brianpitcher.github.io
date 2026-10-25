// Brian Pitcher
// CS-499

package appointment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {

        // Create a date that is one day in the future
        Date futureDate =
                new Date(
                        System.currentTimeMillis()
                                + 86400000
                );

        // Create an appointment using valid information
        Appointment appointment =
                new Appointment(
                        "A12345",
                        futureDate,
                        "Doctor appointment"
                );

        // Check that each value was stored correctly
        assertEquals(
                "A12345",
                appointment.getAppointmentId()
        );

        assertEquals(
                futureDate,
                appointment.getAppointmentDate()
        );

        assertEquals(
                "Doctor appointment",
                appointment.getDescription()
        );
    }

    @Test
    public void testInvalidAppointmentId() {

        Date futureDate =
                new Date(
                        System.currentTimeMillis()
                                + 86400000
                );

        // A blank appointment ID should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "",
                        futureDate,
                        "Checkup"
                )
        );
    }


    @Test
    public void testAppointmentIdTooLong() {

        Date futureDate =
                new Date(
                        System.currentTimeMillis()
                                + 86400000
                );

        // An appointment ID over 10 characters should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "12345678901",
                        futureDate,
                        "Checkup"
                )
        );
    }

    @Test
    public void testPastAppointmentDate() {

        // Create a date that is one day in the past
        Date pastDate =
                new Date(
                        System.currentTimeMillis()
                                - 86400000
                );

        // Appointments should not be allowed in the past
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "A12345",
                        pastDate,
                        "Past appointment"
                )
        );
    }

    @Test
    public void testNullAppointmentDate() {

        // A null appointment date should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "A12345",
                        null,
                        "Checkup"
                )
        );
    }

    @Test
    public void testBlankDescription() {

        Date futureDate =
                new Date(
                        System.currentTimeMillis()
                                + 86400000
                );

        // A blank description should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "A12345",
                        futureDate,
                        ""
                )
        );
    }

    @Test
    public void testDescriptionTooLong() {

        Date futureDate =
                new Date(
                        System.currentTimeMillis()
                                + 86400000
                );

        // A description over 50 characters should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "A12345",
                        futureDate,
                        "This description is intentionally longer than fifty characters."
                )
        );
    }
}