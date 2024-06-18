package za.co.cput.domain;

import jakarta.persistence.*;

@Entity
public class Customer extends User  {

    @Embedded
    private Address address;
}