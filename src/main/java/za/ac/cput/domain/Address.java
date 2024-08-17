// Address.java
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable {
    @Id
    private String streetNumber;
    private String unitNumber;
    private String complexNumber;
    private String complexName;
    private String apartmentNumber;
    private String streetName;
    private String city;
    private String state;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Default constructor
    public Address() {}

    // Builder constructor
    private Address(Builder builder) {
        this.streetNumber = builder.streetNumber;
        this.unitNumber = builder.unitNumber;
        this.complexNumber = builder.complexNumber;
        this.complexName = builder.complexName;
        this.apartmentNumber = builder.apartmentNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.state = builder.state;
        this.postalCode = builder.postalCode;
        this.customer = builder.customer;
    }

    // Getters
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

    public Customer getCustomer() {
        return customer;
    }

    // Setters
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setComplexNumber(String complexNumber) {
        this.complexNumber = complexNumber;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Builder class
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
        private Customer customer;

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

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(unitNumber, address.unitNumber) &&
                Objects.equals(complexNumber, address.complexNumber) &&
                Objects.equals(complexName, address.complexName) &&
                Objects.equals(apartmentNumber, address.apartmentNumber) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(customer, address.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, unitNumber, complexNumber, complexName, apartmentNumber, streetName, city, state, postalCode, customer);
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
                ", customer=" + customer +
                '}';
    }
}