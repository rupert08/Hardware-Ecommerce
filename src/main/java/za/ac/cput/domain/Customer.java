package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Customer extends User  {
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
}