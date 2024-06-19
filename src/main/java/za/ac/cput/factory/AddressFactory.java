package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address createAddress(String streetNumber, String unitNumber, String complexNumber, String complexName,
                                        String apartmentNumber, String streetName, String city, String state, String postalCode) {

//        if (Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName)|| Helper.isNullOrEmpty(city)|| Helper.isNullOrEmpty(state)|| Helper.isNullOrEmpty(postalCode)) {
//            return null;
//        }
//        return new Address.Builder().setStreetNumber(streetNumber).setStreetName(streetName).setCity(city).setState(state).setPostalCode(postalCode).build();
//    }
        if (Helper.isValidStandaloneAddress(streetNumber, streetName, city, state, postalCode) ||
                Helper.isValidApartmentAddress(apartmentNumber, complexName, streetName, city, state, postalCode) ||
                Helper.isValidUnitAddress(unitNumber, complexName, streetName, city, state, postalCode)) {
            return new Address.Builder()
                    .setStreetNumber(streetNumber)
                    .setUnitNumber(unitNumber)
                    .setComplexNumber(complexNumber)
                    .setComplexName(complexName)
                    .setApartmentNumber(apartmentNumber)
                    .setStreetName(streetName)
                    .setCity(city)
                    .setState(state)
                    .setPostalCode(postalCode)
                    .build();
        } else {
            return null;
        }
    }
}
