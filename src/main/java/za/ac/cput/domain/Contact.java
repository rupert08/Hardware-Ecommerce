package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Contact implements Serializable {
    @Column(unique = true)
    private String email;
    private String phoneNumber;

    protected Contact() {
    }

    public Contact(Builder builder) {
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
 public static class Builder {
     private String email;
     private String phoneNumber;

     public Builder setEmail(String email) {
         this.email = email;
         return this;
     }

     public Builder setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber;
         return this;
     }

     public Builder copy (Contact contact){
         this.email = contact.email;
         this.phoneNumber = contact.phoneNumber;
         return this;
     }
     public Contact build () {return new Contact(this);}

     }
 }
