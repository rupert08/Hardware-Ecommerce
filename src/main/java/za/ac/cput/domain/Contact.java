package za.ac.cput.domain;

import jakarta.persistence.*;

@Embeddable
public class Contact {

    @Column(unique = true)
    private String email;
    private String phoneNumber;
}