package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ecommerce/admin";
    private static Contact contact = ContactFactory.createContact("jeff@gmail.com", "0612345679");
    private static Admin admin = AdminFactory.createAdmin(contact.getEmail(), "12345", "Admin", contact);

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(url, admin, Admin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Admin adminSaved = postResponse.getBody();
        assertEquals(admin.getUserId(), adminSaved.getUserId());
        System.out.println("Saved Admin: " + adminSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + admin.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<Admin> response = restTemplate.getForEntity(url, Admin.class);
        assertEquals(admin.getUserId(), response.getBody().getUserId());
        System.out.println("READ: " + response.getBody());
    }

    @Test
    void c_delete() {
        String url = BASE_URL + "/delete/" + admin.getUserId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Admin successfully deleted!");
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("SHOW ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}