package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.AddressHelper;
import za.ac.cput.util.ContactHelper;
import za.ac.cput.util.Helper;

import java.util.Collections;
import java.util.List;

public class CustomerFactory {
    public static Customer createCustomer1(String username, String password, String role) {
        if (ContactHelper.isValidEmail(username) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(role)) {

            throw new IllegalArgumentException(
                    "Can not have null or empty values in required fields!!!");
        }
        Contact contact = new Contact.Builder()
                .setEmail(username)
                .build();

        return new Customer.Builder()
                .setContact(contact)
                .setUsername(username)
                .setPassword(password)
                .setRole(role)
                .build();
    }


    public static Customer createCustomer2(String username, String firstname, String lastname, Contact contact, String password, String role, List <Address> addresses) {
        if (ContactHelper.isValidEmail(username)) {
            throw new IllegalArgumentException("Invalid username ");
        }
        if (Helper.isNullOrEmpty(firstname)) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(lastname)) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        if (addresses == null) {
            addresses = Collections.emptyList();
        }
        return new Customer.Builder()
                .setUsername(username)
                .setFirstName(firstname)
                .setLastName(lastname)
                .setContact(contact)
                .setPassword(password)
                .setRole(role)
                .setAddresses(addresses)
                .build();
    }

}

