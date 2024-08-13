package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.ContactHelper;
import za.ac.cput.util.Helper;

public class ContactFactory {


    public static Contact createContact(String email, String phoneNumber) {
        if (ContactHelper.isValidEmail(email)) {
            throw  new IllegalArgumentException("Check Validation- " +
                    "Make sure Values are correct and are not null for email");
        }
        if(!Helper.isNullOrEmpty(phoneNumber)){
            if(!ContactHelper.isValidPhoneNumber(phoneNumber)) {
                throw  new IllegalArgumentException("Check Validation- " +
                        "Make sure Values are correct and are not null for Phone number!!!");

            }
        }
        return new Contact.Builder()
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }

}
