// Brian Pitcher
// CS-499

package appointment;

import java.util.Date;

public class Appointment {

    // Stores the information for one appointment
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    public Appointment(
            String appointmentId,
            Date appointmentDate,
            String description) {

        // Apointment ID cannot be blank and cannot exceed ten characters
        if (appointmentId == null ||
                appointmentId.trim().isEmpty() ||
                appointmentId.trim().length() > 10) {

            throw new IllegalArgumentException(
                    "Appointment ID must be between 1 and 10 characters.");
        }

        // Appointment date cannot be null or in the past
        if (appointmentDate == null ||
                appointmentDate.before(new Date())) {

            throw new IllegalArgumentException(
                    "Appointment date must be in the future.");
        }

        // Description can't be blank and cannot exceed fifty characters
        if (description == null ||
                description.trim().isEmpty() ||
                description.trim().length() > 50) {

            throw new IllegalArgumentException(
                    "Appointment description must be between 1 and 50 characters.");
        }

        // Save the validated appointment information
        this.appointmentId =
                appointmentId.trim();

        // Store a copy of the date so it cannot be changed from outside
        this.appointmentDate =
                new Date(appointmentDate.getTime());

        this.description =
                description.trim();
    }

    // Return the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Return a copy of the appointment date
    public Date getAppointmentDate() {

        return new Date(
                appointmentDate.getTime()
        );
    }

    // Return the appointment description
    public String getDescription() {
        return description;
    }
}