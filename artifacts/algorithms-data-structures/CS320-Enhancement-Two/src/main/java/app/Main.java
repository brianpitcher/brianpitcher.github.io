// Brian Pitcher
// CS-499

package app;

import appointment.AppointmentService;
import contact.ContactService;
import task.TaskService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create the service objects used by the application
        ContactService contactService =
                new ContactService();

        TaskService taskService =
                new TaskService();

        AppointmentService appointmentService =
                new AppointmentService();

        // Scanner is used to read input from the user
        Scanner scanner =
                new Scanner(System.in);

        // Keeps the main menu running until the user chooses to exit
        boolean applicationRunning = true;

        System.out.println(
                "Welcome to the Service Management Application.");

        // Continue showing the main menu while the application is running
        while (applicationRunning) {

            System.out.println();
            System.out.println("Main Menu");
            System.out.println("1. Manage Contacts");
            System.out.println("2. Manage Tasks");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Search and Sort Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's main menu choice
            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    // Open the contact management menu
                    ContactMenu.showMenu(
                            scanner,
                            contactService
                    );

                    break;

                case "2":

                    // Open the task management menu
                    TaskMenu.showMenu(
                            scanner,
                            taskService
                    );

                    break;

                case "3":

                    // Open the appointment management menu
                    AppointmentMenu.showMenu(
                            scanner,
                            appointmentService
                    );

                    break;

                case "4":

                    // Open the search and sort menu
                    DataManagementMenu.showMenu(
                            scanner,
                            contactService,
                            taskService,
                            appointmentService
                    );

                    break;

                case "5":

                    // Stop the main loop and close the application
                    applicationRunning = false;
                    break;

                default:

                    // Handle a menu choice that does not exist
                    System.out.println(
                            "Invalid selection. Please choose 1 through 5.");

                    break;
            }
        }

        // Close the scanner when the program is finished
        scanner.close();

        System.out.println();
        System.out.println(
                "Application closed.");
    }
}
