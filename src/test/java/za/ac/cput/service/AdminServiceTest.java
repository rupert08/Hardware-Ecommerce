package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    private static Contact contact1 = ContactFactory.createContact("admin5@gmail.com", "0812345679");
    private static Admin admin1 = AdminFactory.createAdmin(contact1.getEmail(), "password", contact1);

    @Test
    @Order(1)
    void create() {
        Admin created = adminService.create(admin1);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Admin read = adminService.read(admin1.getUserId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Disabled
    @Order(3)
    void delete() {
        adminService.delete(admin1.getUserId());
        System.out.println("Admin deleted where User ID: " + admin1.getUserId());
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(adminService.getAll());
    }

    @Test
    @Order(5)
    void findByUsernameAndPassword() {
        Admin findByUser = adminService.findByUsernameAndPassword(admin1.getUsername(), admin1.getPassword());
        assertNotNull(findByUser);
        System.out.println(findByUser);
    }
}