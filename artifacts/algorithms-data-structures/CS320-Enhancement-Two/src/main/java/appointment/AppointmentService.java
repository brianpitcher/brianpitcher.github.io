// Brian Pitcher
// CS-499

package appointment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService {

    // Stores appointments using the appointment ID as the key
    private final Map<String, Appointment> appointments =
            new HashMap<>();

    // Add a new appointment
    public void addAppointment(Appointment appointment) {

        // Appointment IDs must be unique
        if (appointments.containsKey(
                appointment.getAppointmentId())) {

            throw new IllegalArgumentException(
                    "Appointment ID already exists.");
        }

        // Save the appointment using its ID
        appointments.put(
                appointment.getAppointmentId(),
                appointment
        );
    }

    // Delete an appointment using its ID
    public void deleteAppointment(String appointmentId) {

        // Make sure the appointment exists before deleting it
        if (!appointments.containsKey(appointmentId)) {

            throw new IllegalArgumentException(
                    "Appointment ID not found.");
        }

        appointments.remove(appointmentId);
    }

    // Update an existing appointment.
    public void updateAppointment(
            String appointmentId,
            Appointment newAppointment) {

        // Make sure the appointment exists before updating it.
        if (!appointments.containsKey(appointmentId)) {

            throw new IllegalArgumentException(
                    "Appointment ID not found.");
        }

        // Make sure the replacement appointment uses the same ID.
        if (!appointmentId.equals(
                newAppointment.getAppointmentId())) {

            throw new IllegalArgumentException(
                    "Appointment IDs must match.");
        }

        // Replace the old appointment with the updated one
        appointments.put(
                appointmentId,
                newAppointment
        );
    }

    // Find and return an appointment using its ID
    public Appointment getAppointment(
            String appointmentId) {


        // Throw an error if the appointment cannot be found
        if (!appointments.containsKey(appointmentId)) {

            throw new IllegalArgumentException(
                    "Appointment ID not found.");
        }

        return appointments.get(appointmentId);
    }

    // Check whether an appointment ID already exists
    public boolean appointmentExists(
            String appointmentId) {

        return appointments.containsKey(
                appointmentId);
    }

    // Search for appointments using the description
    public List<Appointment> searchAppointmentsByDescription(
            String searchValue) {

        // Do not allow an empty search
        if (searchValue == null ||
                searchValue.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Search value cannot be blank.");
        }

        // Stores any appointments that match the search
        List<Appointment> results =
                new ArrayList<>();

        // Ignore capitalization while searching
        String searchText =
                searchValue.trim().toLowerCase();

        // Check each appointment stored in the HashMap
        for (Appointment appointment : appointments.values()) {

            String description =
                    appointment.getDescription().toLowerCase();

            // Add the appointment if its description contains the search text
            if (description.contains(searchText)) {

                results.add(appointment);
            }
        }

        return results;
    }

    // Return all appointments sorted by date
    public List<Appointment> getAppointmentsSortedByDate() {

        // Copy the HashMap values into a List
        List<Appointment> sortedAppointments =
                new ArrayList<>(appointments.values());

        // Sort the appointments from earliest to latest
        sortedAppointments.sort(
                Comparator.comparing(
                        Appointment::getAppointmentDate)
        );

        return sortedAppointments;
    }
}

