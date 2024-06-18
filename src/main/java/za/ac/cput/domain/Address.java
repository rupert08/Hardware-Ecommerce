package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements Serializable {
    private String streetNumber;
    private String unitNumber;
    private String complexNumber;
    private String complexName;
    private String apartmentNumber;
    private String streetName;
    private String city;
    private String state;
    private String postalCode;

    protected Address() {}

    public Address (Builder builder) {
        this.streetNumber = builder.streetNumber;
        this.unitNumber = builder.unitNumber;
        this.complexNumber = builder.complexNumber;
        this.complexName = builder.complexName;
        this.apartmentNumber = builder.apartmentNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.state = builder.state;
        this.postalCode = builder.postalCode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetNumber, address.streetNumber) && Objects.equals(unitNumber, address.unitNumber) && Objects.equals(complexNumber, address.complexNumber) && Objects.equals(complexName, address.complexName) && Objects.equals(apartmentNumber, address.apartmentNumber) && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, unitNumber, complexNumber, complexName, apartmentNumber, streetName, city, state, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", unitNumber='" + unitNumber + '\'' +
                ", complexNumber='" + complexNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private String streetNumber;
        private String unitNumber;
        private String complexNumber;
        private String complexName;
        private String apartmentNumber;
        private String streetName;
        private String city;
        private String state;
        private String postalCode;

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexNumber(String complexNumber) {
            this.complexNumber = complexNumber;
            return this;
        }

        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder setApartmentNumber(String apartmentNumber) {
            this.apartmentNumber = apartmentNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy (Address address) {
            this.streetNumber = address.streetNumber;
            this.unitNumber = address.unitNumber;
            this.complexNumber = address.complexNumber;
            this.complexName = address.complexName;
            this.apartmentNumber = address.apartmentNumber;
            this.streetName = address.streetName;
            this.city = address.city;
            this.state = address.state;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
