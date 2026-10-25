// Brian Pitcher
// CS-499

package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {

        // Create a fresh service before each test
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {

        // Create a valid contact
        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        // Add the contact to the service
        contactService.addContact(contact);

        // Retrieve the saved contact
        Contact savedContact =
                contactService.getContact("12345");

        // Check that the contact was stored correctly
        assertEquals(
                "Billy",
                savedContact.getFirstName()
        );
    }

    @Test
    public void testDuplicateContactId() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        contactService.addContact(contact);

        // Adding the same contact ID again should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.addContact(contact)
        );
    }

    @Test
    public void testUpdateContact() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        contactService.addContact(contact);

        // Update each editable part of the contact
        contactService.updateFirstName(
                "12345",
                "Michael"
        );

        contactService.updateLastName(
                "12345",
                "Smith"
        );

        contactService.updatePhone(
                "12345",
                "9876543210"
        );

        contactService.updateAddress(
                "12345",
                "100 New Street"
        );

        // Retrieve the contact after the updates
        Contact updatedContact =
                contactService.getContact("12345");

        // Check that all changes were saved
        assertEquals(
                "Michael",
                updatedContact.getFirstName()
        );

        assertEquals(
                "Smith",
                updatedContact.getLastName()
        );

        assertEquals(
                "9876543210",
                updatedContact.getPhone()
        );

        assertEquals(
                "100 New Street",
                updatedContact.getAddress()
        );
    }

    @Test
    public void testDeleteContact() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        contactService.addContact(contact);

        // Delete the contact
        contactService.deleteContact("12345");

        // The deleted contact should no longer be found

        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.getContact("12345")
        );
    }

    @Test
    public void testGetNonExistentContact() {

        // Trying to retrieve a missing contact should cause an error.
        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.getContact("99999")
        );
    }

    @Test
    public void testUpdateNonExistentContact() {

        // Trying to update a missing contact should cause an error.
        assertThrows(
                IllegalArgumentException.class,
                () -> contactService.updateFirstName(
                        "99999",
                        "Michael"
                )
        );
    }

    @Test
    public void testSearchContactsByName() {

        // Create contacts to use for the search
        Contact contact1 = new Contact(
                "10001",
                "Billy",
                "Smith",
                "1234567890",
                "10 Main St"
        );

        Contact contact2 = new Contact(
                "10002",
                "Sarah",
                "Jones",
                "2345678901",
                "20 Main St"
        );

        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Search for a contact by last name
        List<Contact> results =
                contactService.searchContactsByName(
                        "Smith"
                );

        // Check that the correct contact was found
        assertEquals(
                1,
                results.size()
        );

        assertEquals(
                "Billy",
                results.get(0).getFirstName()
        );
    }

    @Test
    public void testSearchIgnoresCapitalization() {

        Contact contact = new Contact(
                "10001",
                "Michael",
                "Johnson",
                "1234567890",
                "10 Main St"
        );

        contactService.addContact(contact);

        // Search using part of the name with different capitalization
        List<Contact> results =
                contactService.searchContactsByName(
                        "john"
                );

        // Check that the contact was still found
        assertEquals(
                1,
                results.size()
        );

        assertEquals(
                "Johnson",
                results.get(0).getLastName()
        );
    }

    @Test
    public void testContactsSortedByName() {

        // Add contacts in an unsorted order
        contactService.addContact(
                new Contact(
                        "10001",
                        "Sarah",
                        "Smith",
                        "1234567890",
                        "10 Main St"
                )
        );

        contactService.addContact(
                new Contact(
                        "10002",
                        "Billy",
                        "Adams",
                        "2345678901",
                        "20 Main St"
                )
        );

        contactService.addContact(
                new Contact(
                        "10003",
                        "Adam",
                        "Smith",
                        "3456789012",
                        "30 Main St"
                )
        );

        // Get the contacts in sorted order
        List<Contact> sortedContacts =
                contactService.getContactsSortedByName();

        // Check that last names are sorted first
        assertEquals(
                "Adams",
                sortedContacts.get(0).getLastName()
        );

        // Matching last names should then sort by first name
        assertEquals(
                "Adam",
                sortedContacts.get(1).getFirstName()
        );

        assertEquals(
                "Sarah",
                sortedContacts.get(2).getFirstName()
        );
    }
}
