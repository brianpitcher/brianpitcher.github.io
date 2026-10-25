// Brian Pitcher
// CS-499

package contact;

public class Contact {

    // Stores the information for one contact
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName,
                   String lastName, String phone, String address) {

        // Contact ID must contain 1 to 10 numbers
        if (contactId == null ||
                !contactId.trim().matches("\\d{1,10}")) {

            throw new IllegalArgumentException(
                    "Contact ID must contain 1 to 10 numbers.");
        }

        // First name cannot be blank and can be up to 20 characters
        if (firstName == null ||
                firstName.trim().isEmpty() ||
                firstName.trim().length() > 20) {

            throw new IllegalArgumentException(
                    "First name must be between 1 and 20 characters.");
        }

        // Last name cannot be blank and can be up to 20 characters
        if (lastName == null ||
                lastName.trim().isEmpty() ||
                lastName.trim().length() > 20) {

            throw new IllegalArgumentException(
                    "Last name must be between 1 and 20 characters.");
        }

        // Phone number must contain exactly 10 numbers
        if (phone == null ||
                !phone.trim().matches("\\d{10}")) {

            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 numbers.");
        }

        // Address cannot be blank and can be up to 30 characters
        if (address == null ||
                address.trim().isEmpty() ||
                address.trim().length() > 30) {

            throw new IllegalArgumentException(
                    "Address must be between 1 and 30 characters.");
        }

        // Save the validated contact information
        this.contactId = contactId.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.phone = phone.trim();
        this.address = address.trim();
    }

    // Return the contact ID
    public String getContactId() {
        return contactId;
    }

    // Return the contact's first name
    public String getFirstName() {
        return firstName;
    }

    // Update the first name after checking that it is valid
    public void setFirstName(String firstName) {

        if (firstName == null ||
                firstName.trim().isEmpty() ||
                firstName.trim().length() > 20) {

            throw new IllegalArgumentException(
                    "First name must be between 1 and 20 characters.");
        }

        this.firstName = firstName.trim();
    }

    // Return the contact's last name
    public String getLastName() {
        return lastName;
    }

    // Update the last name after checking that it is valid
    public void setLastName(String lastName) {

        if (lastName == null ||
                lastName.trim().isEmpty() ||
                lastName.trim().length() > 20) {

            throw new IllegalArgumentException(
                    "Last name must be between 1 and 20 characters.");
        }

        this.lastName = lastName.trim();
    }

    // Return the contact's phone number
    public String getPhone() {
        return phone;
    }

    // Update the phone number after checking that it is valid
    public void setPhone(String phone) {

        if (phone == null ||
                !phone.trim().matches("\\d{10}")) {

            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 numbers.");
        }

        this.phone = phone.trim();
    }

    // Return the contact's address
    public String getAddress() {
        return address;
    }

    // Update the address after checking that it is valid
    public void setAddress(String address) {

        if (address == null ||
                address.trim().isEmpty() ||
                address.trim().length() > 30) {

            throw new IllegalArgumentException(
                    "Address must be between 1 and 30 characters.");
        }

        this.address = address.trim();
    }
}

