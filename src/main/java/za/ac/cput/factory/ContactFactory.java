package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {


    public static Contact createContact(String email, String phoneNumber) {
        if (Helper.isValidEmail(email) || !Helper.isValidPhoneNumber(phoneNumber)) {
            return null;
        }
        return new Contact.Builder()
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }

}
