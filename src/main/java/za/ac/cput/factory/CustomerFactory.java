package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.AddressHelper;
import za.ac.cput.util.ContactHelper;
import za.ac.cput.util.Helper;

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

    public static Customer createCustomer2(String username, String firstname, String lastname, Contact contact, String password, String role, Address address) {
if( address != null){
    if (ContactHelper.isValidEmail(username) || Helper.isNullOrEmpty(firstname) || Helper.isNullOrEmpty(lastname) || Helper.isNullOrEmpty(String.valueOf(contact)) || Helper.isNullOrEmpty(password)
            || Helper.isNullOrEmpty(role) ) {
        throw new RuntimeException("Customer can not have Illegal/null values in required fields");
    }
    if (Helper.isNullOrEmpty(address.getPostalCode())) {
        throw new IllegalArgumentException("Postal Code can not be Empty.");
            }
    if (!AddressHelper.isValidPostalCode(address.getPostalCode())) {
        throw new IllegalArgumentException("Postal Code can Not be less then 4 character or more then 5");
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
else  {
    return new Customer.Builder()
            .setUsername(username)
            .setFirstName(firstname)
            .setLastName(lastname)
            .setContact(contact)
            .setPassword(password)
            .setRole(role)
            .build();

}

    }

}

