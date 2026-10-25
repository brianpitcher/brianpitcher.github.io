// Brian Pitcher
// CS-499

package app;

import appointment.Appointment;
import appointment.AppointmentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppointmentMenu {

    public static void showMenu(
            Scanner scanner,
            AppointmentService appointmentService) {

        // Keeps the appointment menu running until the user goes back
        boolean appointmentMenuRunning = true;

        while (appointmentMenuRunning) {

            System.out.println();
            System.out.println("Appointment Menu");
            System.out.println("1. Add Appointment");
            System.out.println("2. Update Appointment");
            System.out.println("3. Delete Appointment");
            System.out.println("4. View Appointment");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Read the user's menu choice.
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    // Add a new appointment
                    addAppointment(
                            scanner,
                            appointmentService
                    );
                    break;

                case "2":
                    // Update an existing appointment
                    updateAppointment(
                            scanner,
                            appointmentService
                    );
                    break;

                case "3":
                    // Delete an existing appointment
                    deleteAppointment(
                            scanner,
                            appointmentService
                    );
                    break;

                case "4":
                    // Display an existing appointment
                    viewAppointment(
                            scanner,
                            appointmentService
                    );
                    break;

                case "5":
                    // Returnn to the main menu
                    appointmentMenuRunning = false;
                    break;

                default:
                    // Handle an invalid menu choice
                    System.out.println(
                            "Invalid selection. Please choose 1 through 5.");
                    break;
            }
        }
    }

    // Adds a new appointment
    private static void addAppointment(
            Scanner scanner,
            AppointmentService appointmentService) {

        System.out.println();
        System.out.println("Add Appointment");

        String appointmentId;

        // Keep asking until a valid and unique ID is entered
        while (true) {

            System.out.print(
                    "Enter appointment ID (1 to 10 characters): ");

            appointmentId =
                    scanner.nextLine().trim();

            if (appointmentId.isEmpty()) {

                System.out.println(
                        "Error: Appointment ID cannot be blank.");

            } else if (appointmentId.length() > 10) {

                System.out.println(
                        "Error: Appointment ID cannot be longer than 10 characters.");

                // Make sure the ID is not already being used
            } else if (appointmentService
                    .appointmentExists(appointmentId)) {

                System.out.println(
                        "Error: That appointment ID is already being used.");

            } else {

                break;
            }
        }

        // Read and validate the appointment date
        Date appointmentDate =
                readFutureDate(scanner);

        // Read and validate the appointment description
        String description =
                readDescription(scanner);

        try {

            // Create the appointment using the entered information
            Appointment appointment =
                    new Appointment(
                            appointmentId,
                            appointmentDate,
                            description
                    );

            // Add the appointment to the service
            appointmentService.addAppointment(
                    appointment);

            System.out.println(
                    "Appointment added successfully.");

        } catch (IllegalArgumentException e) {

            // Display any validation error that occurs
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    // Updates an existing appointment
    private static void updateAppointment(
            Scanner scanner,
            AppointmentService appointmentService) {

        System.out.println();
        System.out.println("Update Appointment");

        System.out.print(
                "Enter appointment ID: ");

        String appointmentId =
                scanner.nextLine().trim();

        // Make sure the appointment exists before showing update choices
        if (!appointmentService
                .appointmentExists(appointmentId)) {

            System.out.println(
                    "Error: Appointment ID not found.");

            return;
        }

        // get the current appointment so unchanged values can be kept
        Appointment currentAppointment =
                appointmentService.getAppointment(
                        appointmentId);

        System.out.println();
        System.out.println(
                "What would you like to update?");
        System.out.println("1. Appointment Date");
        System.out.println("2. Description");
        System.out.print("Enter your choice: ");

        // Read which part of the appointment the user wants to change
        String choice =
                scanner.nextLine();

        try {

            switch (choice) {

                case "1":

                    // Read a new valid appointment date
                    Date newDate =
                            readFutureDate(scanner);

                    // Create a replacement appointment with the new date
                    Appointment updatedDate =
                            new Appointment(
                                    appointmentId,
                                    newDate,
                                    currentAppointment
                                            .getDescription()
                            );

                    // Replace the old appointment with the updated one
                    appointmentService
                            .updateAppointment(
                                    appointmentId,
                                    updatedDate
                            );

                    System.out.println(
                            "Appointment date updated successfully.");
                    break;

                case "2":

                    //Read a new valid description
                    String newDescription =
                            readDescription(scanner);

                    // Create a replacement appointment with the new description
                    Appointment updatedDescription =
                            new Appointment(
                                    appointmentId,
                                    currentAppointment
                                            .getAppointmentDate(),
                                    newDescription
                            );

                    // Replace the old appointment with the updated one
                    appointmentService
                            .updateAppointment(
                                    appointmentId,
                                    updatedDescription
                            );

                    System.out.println(
                            "Appointment description updated successfully.");
                    break;

                default:

                    // Handle an invalid update choice
                    System.out.println(
                            "Invalid selection.");
                    break;
            }

        } catch (IllegalArgumentException e) {

            // Display any error that occurs while updating
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    // Deletes an appointment
    private static void deleteAppointment(
            Scanner scanner,
            AppointmentService appointmentService) {

        System.out.println();
        System.out.println("Delete Appointment");

        System.out.print(
                "Enter appointment ID: ");

        String appointmentId =
                scanner.nextLine().trim();

        // Make sure the appointment exists before deleting it
        if (!appointmentService
                .appointmentExists(appointmentId)) {

            System.out.println(
                    "Error: Appointment ID not found.");

            return;
        }

        try {

            // Delete the appointment that matches the entered ID
            appointmentService
                    .deleteAppointment(appointmentId);

            System.out.println(
                    "Appointment deleted successfully.");

        } catch (IllegalArgumentException e) {

            // Display an error if the appointment cannot be deleted
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    // Displays an appointment
    private static void viewAppointment(
            Scanner scanner,
            AppointmentService appointmentService) {

        System.out.println();
        System.out.println("View Appointment");

        System.out.print(
                "Enter appointment ID: ");

        String appointmentId =
                scanner.nextLine().trim();

        // Make sure the appointment exists before displaying it
        if (!appointmentService
                .appointmentExists(appointmentId)) {

            System.out.println(
                    "Error: Appointment ID not found.");

            return;
        }

        try {

            // Find the appointment using its ID.
            Appointment appointment =
                    appointmentService
                            .getAppointment(
                                    appointmentId);

            // Format the date so it is easier for the user to read
            SimpleDateFormat dateFormat =
                    new SimpleDateFormat(
                            "MM/dd/yyyy");

            // Display the saved appointment information
            System.out.println();
            System.out.println(
                    "Appointment Information");

            System.out.println(
                    "ID: "
                            + appointment
                            .getAppointmentId());

            System.out.println(
                    "Date: "
                            + dateFormat.format(
                            appointment
                                    .getAppointmentDate()));

            System.out.println(
                    "Description: "
                            + appointment
                            .getDescription());

        } catch (IllegalArgumentException e) {

            // Display an error if the appointment cannot be found
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    // Keeps asking until the user enters a valid future date
    private static Date readFutureDate(
            Scanner scanner) {

        while (true) {

            System.out.print(
                    "Enter appointment date (MM/dd/yyyy): ");

            String dateInput =
                    scanner.nextLine().trim();

            SimpleDateFormat dateFormat =
                    new SimpleDateFormat(
                            "MM/dd/yyyy");

            // Prevent invalid dates (such as 02/30/2027)
            dateFormat.setLenient(false);

            try {

                // Convert the user's text into a Date object
                Date date =
                        dateFormat.parse(dateInput);

                // Appointments cannot be scheduled in the past
                if (date.before(new Date())) {

                    System.out.println(
                            "Error: Appointment date must be in the future.");

                } else {

                    return date;
                }

            } catch (ParseException e) {

                // Handle an incorrectly formatted or invalid date
                System.out.println(
                        "Error: Please enter the date as MM/dd/yyyy.");
            }
        }
    }

    // Keeps asking until the user enters a valid description
    private static String readDescription(
            Scanner scanner) {

        while (true) {

            System.out.print(
                    "Enter appointment description: ");

            String description =
                    scanner.nextLine().trim();

            if (description.isEmpty()) {

                System.out.println(
                        "Error: Description cannot be blank.");

            } else if (description.length() > 50) {

                System.out.println(
                        "Error: Description cannot be longer than 50 characters.");

            } else {

                return description;
            }
        }
    }
}