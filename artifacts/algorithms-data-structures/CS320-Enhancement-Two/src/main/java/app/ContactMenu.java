// Brian Pitcher
// CS-499

package app;

import contact.Contact;
import contact.ContactService;

import java.util.Scanner;

public class ContactMenu {

    public static void showMenu(
            Scanner scanner,
            ContactService contactService) {

        // Keeps the contact menu running until the user goes back
        boolean contactMenuRunning = true;

        while (contactMenuRunning) {

            System.out.println();
            System.out.println("Contact Menu");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contact");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Read the user's menu choice
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    // Add a new contact
                    addContact(scanner, contactService);
                    break;

                case "2":
                    // Update an existing contact
                    updateContact(scanner, contactService);
                    break;

                case "3":
                    // Delete an existing contact
                    deleteContact(scanner, contactService);
                    break;

                case "4":
                    // Display an existing contact
                    viewContact(scanner, contactService);
                    break;

                case "5":
                    // return to the main menu
                    contactMenuRunning = false;
                    break;

                default:
                    // Handle an invalid menu choice
                    System.out.println(
                            "Invalid selection. Please choose 1 through 5.");
                    break;
            }
        }
    }

    private static void addContact(
            Scanner scanner,
            ContactService contactService) {

        System.out.println();
        System.out.println("Add Contact");

        String contactId;

        // Keep asking until a valid and unique contact ID is entered
        while (true) {

            System.out.print(
                    "Enter contact ID (1 to 10 numbers): ");

            contactId = scanner.nextLine().trim();

            // Contact IDs must only contain 1 to 10 numbers
            if (!contactId.matches("\\d{1,10}")) {

                System.out.println(
                        "Error: Contact ID must contain 1 to 10 numbers.");

                // Check that the ID is not already being used
            } else if (contactService.contactExists(contactId)) {

                System.out.println(
                        "Error: That contact ID is already being used.");

            } else {

                break;
            }
        }

        String firstName;

        // Keep asking until a valid first name is entered.
        while (true) {

            System.out.print("Enter first name: ");
            firstName = scanner.nextLine().trim();

            if (firstName.isEmpty()) {

                System.out.println(
                        "Error: First name cannot be blank.");

            } else if (firstName.length() > 20) {

                System.out.println(
                        "Error: First name cannot be longer than 20 characters.");

            } else {

                break;
            }
        }

        String lastName;

        // Keep asking until a valid last name is entered
        while (true) {

            System.out.print("Enter last name: ");
            lastName = scanner.nextLine().trim();

            if (lastName.isEmpty()) {

                System.out.println(
                        "Error: Last name cannot be blank.");

            } else if (lastName.length() > 20) {

                System.out.println(
                        "Error: Last name cannot be longer than 20 characters.");

            } else {

                break;
            }
        }

        String phone;

        // Keep asking until a valid 10 digit phone number is entered
        while (true) {

            System.out.print(
                    "Enter 10 digit phone number: ");

            phone = scanner.nextLine().trim();

            if (!phone.matches("\\d{10}")) {

                System.out.println(
                        "Error: Phone number must contain exactly 10 numbers.");

            } else {

                break;
            }
        }

        String address;

        // Keep asking until a valid address is entered
        while (true) {

            System.out.print("Enter address: ");
            address = scanner.nextLine().trim();

            if (address.isEmpty()) {

                System.out.println(
                        "Error: Address cannot be blank.");

            } else if (address.length() > 30) {

                System.out.println(
                        "Error: Address cannot be longer than 30 characters.");

            } else {

                break;
            }
        }

        try {

            // Create the contact using the information entered by the user
            Contact contact = new Contact(
                    contactId,
                    firstName,
                    lastName,
                    phone,
                    address
            );

            // Add the contact to the service
            contactService.addContact(contact);

            System.out.println(
                    "Contact added successfully.");

        } catch (IllegalArgumentException e) {

            // Display any validation error that occurs.
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    private static void updateContact(
            Scanner scanner,
            ContactService contactService) {

        System.out.println();
        System.out.println("Update Contact");

        System.out.print("Enter contact ID: ");
        String contactId = scanner.nextLine().trim();

        // make sure the contact exists before showing update choices
        if (!contactService.contactExists(contactId)) {

            System.out.println(
                    "Error: Contact ID not found.");

            return;
        }

        System.out.println();
        System.out.println(
                "What would you like to update?");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Phone Number");
        System.out.println("4. Address");
        System.out.print("Enter your choice: ");

        String choice = scanner.nextLine();

        try {

            switch (choice) {

                case "1":

                    String firstName;

                    // Keep asking until a valid new first name is entered
                    while (true) {

                        System.out.print(
                                "Enter new first name: ");

                        firstName =
                                scanner.nextLine().trim();

                        if (firstName.isEmpty()) {

                            System.out.println(
                                    "Error: First name cannot be blank.");

                        } else if (firstName.length() > 20) {

                            System.out.println(
                                    "Error: First name cannot be longer than 20 characters.");

                        } else {

                            break;
                        }
                    }

                    // Update the contact's first name
                    contactService.updateFirstName(
                            contactId,
                            firstName
                    );

                    System.out.println(
                            "First name updated successfully.");
                    break;

                case "2":

                    String lastName;

                    // Keep asking until a valid new last name is entered
                    while (true) {

                        System.out.print(
                                "Enter new last name: ");

                        lastName =
                                scanner.nextLine().trim();

                        if (lastName.isEmpty()) {

                            System.out.println(
                                    "Error: Last name cannot be blank.");

                        } else if (lastName.length() > 20) {

                            System.out.println(
                                    "Error: Last name cannot be longer than 20 characters.");

                        } else {

                            break;
                        }
                    }

                    // Update the contact's last name
                    contactService.updateLastName(
                            contactId,
                            lastName
                    );

                    System.out.println(
                            "Last name updated successfully.");
                    break;

                case "3":

                    String phone;

                    // Keep asking until a valid new phone number is entered
                    while (true) {

                        System.out.print(
                                "Enter new 10 digit phone number: ");

                        phone =
                                scanner.nextLine().trim();

                        if (!phone.matches("\\d{10}")) {

                            System.out.println(
                                    "Error: Phone number must contain exactly 10 numbers.");

                        } else {

                            break;
                        }
                    }

                    // Update the contact's phone number
                    contactService.updatePhone(
                            contactId,
                            phone
                    );

                    System.out.println(
                            "Phone number updated successfully.");
                    break;

                case "4":

                    String address;

                    // Keep asking until a valid new address is entered
                    while (true) {

                        System.out.print(
                                "Enter new address: ");

                        address =
                                scanner.nextLine().trim();

                        if (address.isEmpty()) {

                            System.out.println(
                                    "Error: Address cannot be blank.");

                        } else if (address.length() > 30) {

                            System.out.println(
                                    "Error: Address cannot be longer than 30 characters.");

                        } else {

                            break;
                        }
                    }


                    // Update the contact's address
                    contactService.updateAddress(
                            contactId,
                            address
                    );

                    System.out.println(
                            "Address updated successfully.");
                    break;

                default:

                    // handle e an invalid update choice
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

    private static void deleteContact(
            Scanner scanner,
            ContactService contactService) {

        System.out.println();
        System.out.println("Delete Contact");

        System.out.print("Enter contact ID: ");
        String contactId = scanner.nextLine().trim();

        try {

            // Delete the contact that matches the entered ID
            contactService.deleteContact(contactId);

            System.out.println(
                    "Contact deleted successfully.");

        } catch (IllegalArgumentException e) {

            // Display an error if the contact does not exist
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    private static void viewContact(
            Scanner scanner,
            ContactService contactService) {

        System.out.println();
        System.out.println("view Contact");

        System.out.print("Enter contact ID: ");
        String contactId = scanner.nextLine().trim();

        try {

            // find the contact using its ID.
            Contact contact =
                    contactService.getContact(contactId);

            // Display the saved contact information
            System.out.println();
            System.out.println("Contact Information");

            System.out.println(
                    "ID: " + contact.getContactId());

            System.out.println(
                    "First Name: "
                            + contact.getFirstName());

            System.out.println(
                    "Last Name: "
                            + contact.getLastName());

            System.out.println(
                    "Phone: "
                            + contact.getPhone());

            System.out.println(
                    "Address: "
                            + contact.getAddress());

        } catch (IllegalArgumentException e) {

            // Display an error if the contact cannot be found
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }
}