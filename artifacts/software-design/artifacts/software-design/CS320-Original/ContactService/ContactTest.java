// Brian Pitcher
// 2/1/2025

package test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testValidContactCreation() {
        // Creates a valid contact and verifies that the fields match expected values
        Contact contact = new Contact("12345", "Billy", "Bob", "0123456789", "88 Easy St");
        assertEquals("12345", contact.getContactId());
        assertEquals("Billy", contact.getFirstName());
        assertEquals("Bob", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("88 Easy St", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreation() {
        // Tests various invalid contact scenarios (for example, null values, invalid lengths)
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Billy", "Bob", "0123456789", "88 Easy St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Billy", "Bob", "0123456789", "88 Easy St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Bob", "0123456789", "88 Easy St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Billy", null, "0123456789", "88 Easy St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Billy", "Bob", "01234", "88 Easy St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Billy", "Bob", "0123456789", null));
    }
}
