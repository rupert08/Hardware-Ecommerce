// AddressFactory.java
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.AddressHelper;

public class AddressFactory {

    public static Address createAddress(String streetNumber, String unitNumber, String complexNumber, String complexName, String apartmentNumber, String streetName, String city, String state, String postalCode) {
        if (!AddressHelper.isValidStreetNumber(streetNumber)) {
            throw new IllegalArgumentException("Invalid street number");
        }
        if (!AddressHelper.isValidPostalCode(postalCode)) {
            throw new IllegalArgumentException("Invalid postal code");
        }
        if (AddressHelper.isValidStandaloneAddress(streetNumber, streetName, city, state, postalCode) ||
                AddressHelper.isValidApartmentAddress(apartmentNumber, complexName, streetName, city, state, postalCode) ||
                AddressHelper.isValidUnitAddress(unitNumber, complexName, streetName, city, state, postalCode)) {
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
            throw new IllegalArgumentException("Invalid address");
        }
    }
}