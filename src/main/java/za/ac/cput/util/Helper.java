package za.ac.cput.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
           return true;
        return false;
    }

    public static boolean isValidEmail(String email) {
        boolean result = false;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = true;
        }
        return result;
    }
    public static boolean isValidPostalCode(String postalCode) {
        return postalCode.matches("\\d{4,5}");
    }

    public static boolean isValidStreetNumber(String streetNumber) {
        return streetNumber.matches("\\d+[a-zA-Z]?");
    }

    public static boolean isValidStandaloneAddress(String streetNumber, String streetName, String city, String state, String postalCode) {
        return !isNullOrEmpty(streetNumber) && !isNullOrEmpty(streetName) && !isNullOrEmpty(city) && !isNullOrEmpty(state) && isValidPostalCode(postalCode);
    }

    public static boolean isValidApartmentAddress(String apartmentNumber, String complexName, String streetName, String city, String state, String postalCode) {
        return !isNullOrEmpty(apartmentNumber) && !isNullOrEmpty(complexName) && !isNullOrEmpty(streetName) && !isNullOrEmpty(city) && !isNullOrEmpty(state) && isValidPostalCode(postalCode);
    }

    public static boolean isValidUnitAddress(String unitNumber, String buildingName, String streetName, String city, String state, String postalCode) {
        return !isNullOrEmpty(unitNumber) && !isNullOrEmpty(buildingName) && !isNullOrEmpty(streetName) && !isNullOrEmpty(city) && !isNullOrEmpty(state) && isValidPostalCode(postalCode);
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+?\\d{10,15}");
    }
}