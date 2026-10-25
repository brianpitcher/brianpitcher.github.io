// Brian Pitcher
// CS-499

package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {

        // Create a contact using valid information
        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        // Check that each value was stored correctly
        assertEquals(
                "12345",
                contact.getContactId()
        );

        assertEquals(
                "Billy",
                contact.getFirstName()
        );

        assertEquals(
                "Bob",
                contact.getLastName()
        );

        assertEquals(
                "0123456789",
                contact.getPhone()
        );

        assertEquals(
                "88 Easy St",
                contact.getAddress()
        );
    }

    @Test
    public void testInvalidContactId() {

        // A contact ID with letters should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "ABC123",
                        "Billy",
                        "Bob",
                        "0123456789",
                        "88 Easy St"
                )
        );
    }

    @Test
    public void testFirstNameTooLong() {

        // A first name over 20 characters should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "12345",
                        "ThisFirstNameIsWayTooLong",
                        "Bob",
                        "0123456789",
                        "88 Easy St"
                )
        );
    }

    @Test
    public void testBlankFirstName() {

        // A blank first name should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "12345",
                        "",
                        "Bob",
                        "0123456789",
                        "88 Easy St"
                )
        );
    }

    @Test
    public void testInvalidPhoneNumber() {

        // The phone number must contain exactly 10 numbers
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "12345",
                        "Billy",
                        "Bob",
                        "12345",
                        "88 Easy St"
                )
        );
    }

    @Test
    public void testInvalidAddress() {

        // a blank address should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "12345",
                        "Billy",
                        "Bob",
                        "0123456789",
                        ""
                )
        );
    }

    @Test
    public void testUpdateFirstName() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        // Change the first name
        contact.setFirstName("Michael");

        // Check that the first name was updated
        assertEquals(
                "Michael",
                contact.getFirstName()
        );
    }

    @Test
    public void testUpdateLastName() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        // Change the last name
        contact.setLastName("Smith");

        // Check that the last name was updated
        assertEquals(
                "Smith",
                contact.getLastName()
        );
    }

    @Test
    public void testUpdatePhone() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        // Change the phone number
        contact.setPhone("9876543210");

        // Check that the phone number was updated.
        assertEquals(
                "9876543210",
                contact.getPhone()
        );
    }

    @Test
    public void testUpdateAddress() {

        Contact contact = new Contact(
                "12345",
                "Billy",
                "Bob",
                "0123456789",
                "88 Easy St"
        );

        // Change the address
        contact.setAddress(
                "100 New Street"
        );

        // Check that the address was updated
        assertEquals(
                "100 New Street",
                contact.getAddress()
        );
    }

}

