package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Customer extends User {
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;

    protected Customer() {
    }

    public Customer(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
        this.contact = builder.contact;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private long userId;
        private String username;
        private String password;
        private String role;
        private Contact contact;
        private String firstName;
        private String lastName;
        private Address address;

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy (Customer customer) {
            this.userId = customer.userId;
            this.username = customer.username;
            this.password = customer.password;
            this.role = customer.role;
            this.contact = customer.contact;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.address = customer.address;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}