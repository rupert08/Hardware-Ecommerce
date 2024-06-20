package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer1(String username, String password, String role) {
        if (Helper.isValidEmail(username) || Helper.isNullOrEmpty(password)|| Helper.isNullOrEmpty(role)) {
            return null;
        }
        return new Customer.Builder()
                .setUsername(username)
                .setPassword(password)
                .setRole(role)
                .build();
    }

    public static Customer createCustomer2(String username, String firstname, String lastname,Contact contact, String password, String role, Address address) {
        if (Helper.isValidEmail(username) || Helper.isNullOrEmpty(firstname)|| Helper.isNullOrEmpty(lastname)|| Helper.isNullOrEmpty(String.valueOf(contact))|| Helper.isNullOrEmpty(password)
                || Helper.isNullOrEmpty(role)|| Helper.isNullOrEmpty(String.valueOf(address))) {
            return null;
        }

        return new Customer.Builder()
                .setUsername(username)
                .setFirstName(firstname)
                .setLastName(lastname)
                .setContact(contact)
                .setPassword(password)
                .setRole(role)
                .setAddress(address)
                .build();
    }
}
