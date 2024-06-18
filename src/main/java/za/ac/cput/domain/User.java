package za.ac.cput.domain;


import jakarta.persistence.*;


@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String password;
    private String role;

    @Embedded
    private Contact contact;




}