// Brian Pitcher
// CS-499

package contact;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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

        // Throw an error if the contact cannot be found
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

    // Search for contacts using a first or last name
    public List<Contact> searchContactsByName(
            String searchValue) {

        // Do not allow an empty search
        if (searchValue == null ||
                searchValue.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Search value cannot be blank.");
        }

        // Stores any contacts that match the search
        List<Contact> results =
                new ArrayList<>();

        // Ignore capitalization while searching
        String searchText =
                searchValue.trim().toLowerCase();

        // Check each contact stored in the HashMap
        for (Contact contact : contacts.values()) {

            String firstName =
                    contact.getFirstName().toLowerCase();

            String lastName =
                    contact.getLastName().toLowerCase();

            // Add the contact if either name contains the search text
            if (firstName.contains(searchText) ||
                    lastName.contains(searchText)) {

                results.add(contact);
            }
        }

        return results;
    }

    // Return all contacts sorted by last name and then first name
    public List<Contact> getContactsSortedByName() {

        // Copy the HashMap values into a List
        List<Contact> sortedContacts =
                new ArrayList<>(contacts.values());

        // Sort by last name first
        sortedContacts.sort(
                Comparator.comparing(
                                Contact::getLastName,
                                String.CASE_INSENSITIVE_ORDER)

                        // If last names match, sort by first name
                        .thenComparing(
                                Contact::getFirstName,
                                String.CASE_INSENSITIVE_ORDER)
        );

        return sortedContacts;
    }
}
