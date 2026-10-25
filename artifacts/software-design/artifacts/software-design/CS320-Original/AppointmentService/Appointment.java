// Brian Pitcher
// 2/16/2025

package appointment;

import java.util.Date;

public class Appointment {
    // Unique appointment ID, cannot be changed after creation
    private final String appointmentId;
    // Appointment date, must not be in the past
    private final Date appointmentDate;
    // Description of the appointment, with a character limit
    private final String description;

    // Constructor to initialize the appointment object
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointment ID (not null, max 10 characters)
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        // Validate appointment date (not null, not in the past)
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        // Validate description (not null, max 50 characters)
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        
        // Assign values to final fields
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter method to retrieve the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Getter method to retrieve the appointment date (returns a copy to maintain immutability)
    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    // Getter method to retrieve the appointment description
    public String getDescription() {
        return description;
    }
}
