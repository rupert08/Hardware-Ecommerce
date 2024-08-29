package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin createAdmin(String username, String password, Contact contact) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        //fix this so the builder could work

        return Admin.builder()
                .username(username)
                .password(password)
                .contact(contact)
                .build();

    }

    public static Admin adminLogin(String username, String password) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        //fix this so the builder could work

        return Admin.builder()
                .username(username)
                .password(password)
                .build();

    }
}
