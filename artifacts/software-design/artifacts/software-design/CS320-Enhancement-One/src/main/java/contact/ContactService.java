// Brian Pitcher
// CS-499

package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Stores contacts using the contact ID as the key
    private final Map<String, Contact> contacts =
            new HashMap<>();

    // Add a new contact to the collection
    public void addContact(Contact contact) {

        // Contact IDs must be unique
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException(
                    "Contact ID must be unique.");
        }

        // Save the contact using its ID
        contacts.put(
                contact.getContactId(),
                contact
        );
    }

    // Delete a contact using its ID
    public void deleteContact(String contactId) {

        // Make sure the contact exists before deleting it
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact ID not found.");
        }

        contacts.remove(contactId);
    }

    // Update the first name of an existing contact
    public void updateFirstName(
            String contactId,
            String firstName) {

        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    // Update the last name of an existing contact
    public void updateLastName(
            String contactId,
            String lastName) {

        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    // Update the phone number of an existing contact
    public void updatePhone(
            String contactId,
            String phone) {

        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    // Update the address of an existing contact
    public void updateAddress(
            String contactId,
            String address) {

        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    // Find and return a contact using its ID
    public Contact getContact(String contactId) {

        //  Throw an error if the contact cannot be found
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact with ID "
                            + contactId
                            + " not found.");
        }

        return contacts.get(contactId);
    }

    // Check whether a contact ID is already being used
    public boolean contactExists(String contactId) {
        return contacts.containsKey(contactId);
    }
}