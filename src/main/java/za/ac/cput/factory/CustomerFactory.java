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
    public static Customer createCustomer(String username, String password) {
        if (ContactHelper.isValidEmail(username) || Helper.isNullOrEmpty(password)) {

            throw new IllegalArgumentException(
                    "Can not have null or empty values in required fields!!!");
        }
        Contact contact = Contact.builder()
                .email(username)
                .build();

        return Customer.builder()
                .contact(contact)
                .username(username)
                .password(password)
                //
                .build();
    }


    public static Customer createCustomer(String username, String firstname, String lastname, Contact contact, String password, List <Address> address) {
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
        if (address == null) {
            address = Collections.emptyList();
        }
        return  Customer.builder()
                .username(username)
                .firstName(firstname)
                .lastName(lastname)
                .contact(contact)
                .password(password)
                .address(address)
                .build();
    }
    public static Customer createCustomer(String username, String password, String firstName, String lastName, Contact contact) {
        if (ContactHelper.isValidEmail(username)) {
            throw new IllegalArgumentException("Invalid username ");
        }
        if (Helper.isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return  Customer.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .contact(contact)
                .password(password)
                .build();
    }

}

