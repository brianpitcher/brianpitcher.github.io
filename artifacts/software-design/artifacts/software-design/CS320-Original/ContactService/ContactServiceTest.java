// Brian Pitcher
// 2/1/2025

package test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    @Test
    public void testAddAndDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Billy", "Bob", "0123456789", "88 Easy St");

        // Adds a contact and verifies duplicate insertion is prevented
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));

        // Deletes the contact and verifies that deleting a non-existing contact throws an error
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("12345"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Billy", "Bob", "0123456789", "88 Easy St");
        service.addContact(contact);

        // Updates contact details
        service.updateFirstName("12345", "Dick");
        service.updateLastName("12345", "Tracy");
        service.updatePhone("12345", "3609999999");
        service.updateAddress("12345", "421 Abbey Road");

        // Verifies that updates are applied correctly
        assertEquals("Dick", contact.getFirstName());
        assertEquals("Tracy", contact.getLastName());
        assertEquals("3609999999", contact.getPhone());
        assertEquals("421 Abbey Road", contact.getAddress());
    }
}
