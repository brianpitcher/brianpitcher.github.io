// Brian Pitcher
// CS-499

package app;

import appointment.Appointment;
import appointment.AppointmentService;
import contact.Contact;
import contact.ContactService;
import task.Task;
import task.TaskService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class DataManagementMenu {

    public static void showMenu(
            Scanner scanner,
            ContactService contactService,
            TaskService taskService,
            AppointmentService appointmentService) {

        // Keeps the data management menu running until the user goes back
        boolean menuRunning = true;

        while (menuRunning) {

            System.out.println();
            System.out.println("Data Management Menu");
            System.out.println("1. Contacts");
            System.out.println("2. Tasks");
            System.out.println("3. Appointments");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    // Open the contact search and sort options
                    contactOptions(
                            scanner,
                            contactService
                    );

                    break;

                case "2":

                    // Open the task search and sort options.
                    taskOptions(
                            scanner,
                            taskService
                    );

                    break;

                case "3":

                    // Open the appointment search and sort options.
                    appointmentOptions(
                            scanner,
                            appointmentService
                    );

                    break;

                case "4":

                    // Return to the main application menu
                    menuRunning = false;
                    break;

                default:

                    System.out.println(
                            "Invalid selection. Please choose 1 through 4.");

                    break;
            }
        }
    }


    private static void contactOptions(
            Scanner scanner,
            ContactService contactService) {

        System.out.println();
        System.out.println("Contact Data Options");
        System.out.println("1. Search Contacts");
        System.out.println("2. Sort Contacts");
        System.out.println("3. Return");
        System.out.print("Enter your choice: ");

        String choice =
                scanner.nextLine();

        switch (choice) {

            case "1":

                searchContacts(
                        scanner,
                        contactService
                );

                break;

            case "2":

                sortContacts(
                        contactService
                );

                break;

            case "3":

                // Return to the data management menu
                break;

            default:

                System.out.println(
                        "Invalid selection. Please choose 1 through 3.");

                break;
        }
    }

    private static void taskOptions(
            Scanner scanner,
            TaskService taskService) {

        System.out.println();
        System.out.println("Task Data Options");
        System.out.println("1. Search Tasks");
        System.out.println("2. Sort Tasks");
        System.out.println("3. Return");
        System.out.print("Enter your choice: ");

        String choice =
                scanner.nextLine();

        switch (choice) {

            case "1":

                searchTasks(
                        scanner,
                        taskService
                );

                break;

            case "2":

                sortTasks(
                        taskService
                );

                break;

            case "3":

                 // Return to the data management menu.
                break;

            default:

                System.out.println(
                        "Invalid selection. Please choose 1 through 3.");

                break;
        }
    }

    private static void appointmentOptions(
            Scanner scanner,
            AppointmentService appointmentService) {

        System.out.println();
        System.out.println("Appointment Data Options");
        System.out.println("1. Search Appointments");
        System.out.println("2. Sort Appointments");
        System.out.println("3. Return");
        System.out.print("Enter your choice: ");

        String choice =
                scanner.nextLine();

        switch (choice) {

            case "1":

                searchAppointments(
                        scanner,
                        appointmentService
                );

                break;

            case "2":

                sortAppointments(
                        appointmentService
                );

                break;

            case "3":

                // Return to the data management menu
                break;

            default:

                System.out.println(
                        "Invalid selection. Please choose 1 through 3.");

                break;
        }
    }

    private static void searchContacts(
            Scanner scanner,
            ContactService contactService) {

        System.out.println();
        System.out.println("Search Contacts");

        System.out.print(
                "Enter first or last name to search: ");

        String searchValue =
                scanner.nextLine();

        try {

            // Search the stored contacts for matching names
            List<Contact> results =
                    contactService
                            .searchContactsByName(
                                    searchValue
                            );

            if (results.isEmpty()) {

                System.out.println(
                        "No matching contacts found.");

                return;
            }

            System.out.println();
            System.out.println(
                    "Matching Contacts");

            // Display every contact that matched the search
            for (Contact contact : results) {

                displayContact(contact);
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    private static void sortContacts(
            ContactService contactService) {

        // Get a List sorted by last name and then first name
        List<Contact> contacts =
                contactService
                        .getContactsSortedByName();

        if (contacts.isEmpty()) {

            System.out.println(
                    "No contacts have been added.");

            return;
        }

        System.out.println();
        System.out.println(
                "Contacts Sorted by Name");

        // Display the contacts in their sorted order
        for (Contact contact : contacts) {

            displayContact(contact);
        }
    }

    private static void searchTasks(
            Scanner scanner,
            TaskService taskService) {

        System.out.println();
        System.out.println("Search Tasks");

        System.out.print(
                "Enter task name to search: ");

        String searchValue =
                scanner.nextLine();

        try {

            // Search the stored tasks for matching names
            List<Task> results =
                    taskService
                            .searchTasksByName(
                                    searchValue
                            );

            if (results.isEmpty()) {

                System.out.println(
                        "No matching tasks found.");

                return;
            }

            System.out.println();
            System.out.println(
                    "Matching Tasks");

            // Display every task that matched the search
            for (Task task : results) {

                displayTask(task);
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    private static void sortTasks(
            TaskService taskService) {

        // Get a List sorted by task name
        List<Task> tasks =
                taskService
                        .getTasksSortedByName();

        if (tasks.isEmpty()) {

            System.out.println(
                    "No tasks have been added.");

            return;
        }

        System.out.println();
        System.out.println(
                "Tasks Sorted by Name");

        // Display the tasks in alphabetical order
        for (Task task : tasks) {

            displayTask(task);
        }
    }

    private static void searchAppointments(
            Scanner scanner,
            AppointmentService appointmentService) {

        System.out.println();
        System.out.println(
                "Search Appointments");

        System.out.print(
                "Enter appointment description to search: ");

        String searchValue =
                scanner.nextLine();

        try {

            // Search the stored appointments for matching descriptions
            List<Appointment> results =
                    appointmentService
                            .searchAppointmentsByDescription(
                                    searchValue
                            );

            if (results.isEmpty()) {

                System.out.println(
                        "No matching appointments found.");

                return;
            }

            System.out.println();
            System.out.println(
                    "Matching Appointments");

            // Display every appointment that matched the search
            for (Appointment appointment : results) {

                displayAppointment(
                        appointment
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    private static void sortAppointments(
            AppointmentService appointmentService) {

        // Get a List sorted from the earliest date to the latest.
        List<Appointment> appointments =
                appointmentService
                        .getAppointmentsSortedByDate();

        if (appointments.isEmpty()) {

            System.out.println(
                    "No appointments have been added.");

            return;
        }

        System.out.println();
        System.out.println(
                "Appointments Sorted by Date");

        // Display the appointments in their sorted order.
        for (Appointment appointment : appointments) {

            displayAppointment(
                    appointment
            );
        }
    }

    private static void displayContact(
            Contact contact) {

        System.out.println();

        System.out.println(
                "ID: "
                        + contact.getContactId());

        System.out.println(
                "Name: "
                        + contact.getFirstName()
                        + " "
                        + contact.getLastName());

        System.out.println(
                "Phone: "
                        + contact.getPhone());

        System.out.println(
                "Address: "
                        + contact.getAddress());
    }


    private static void displayTask(
            Task task) {

        System.out.println();

        System.out.println(
                "ID: "
                        + task.getTaskId());

        System.out.println(
                "Name: "
                        + task.getName());

        System.out.println(
                "Description: "
                        + task.getDescription());
    }

    private static void displayAppointment(
            Appointment appointment) {

        // Format the appointment date for easier reading
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(
                        "MM/dd/yyyy");

        System.out.println();

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
    }

}

