package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin createAdmin(String username, String password, String role, Contact contact) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)|| Helper.isNullOrEmpty(role)) {
            return null;
        }
        return new Admin.Builder().setUsername(username).setPassword(password).setRole(role).setContact(contact).build();
    }
}
