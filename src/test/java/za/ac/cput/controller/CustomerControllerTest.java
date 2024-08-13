package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ecommerce/customer";
    private static Contact contact = ContactFactory.createContact(
            "rupert@gmail.com","0840841616");
    private static Address address = AddressFactory.createAddress(
            "32", "","","",
            "","Moses","Paarl","Western-Cape","");
    private static Customer customer= CustomerFactory.createCustomer2(
            "rupert@gmail.com","rupert","charles",
            contact,"123456","Customer",address);
    private static Customer savedCustomer;

    @Test
    @Order(1)
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Customer> customerResponseEntity =
                restTemplate.postForEntity(url,customer, Customer.class);
        assertNotNull(customerResponseEntity);
        assertNotNull(customerResponseEntity.getBody());

       savedCustomer = customerResponseEntity.getBody();
       customer = new Customer.Builder()
                .setUserId(savedCustomer.getUserId())
                .setFirstName(savedCustomer.getFirstName())
                .setLastName(savedCustomer.getLastName())
                .setContact(savedCustomer.getContact())
                .setPassword(savedCustomer.getPassword())
                .setRole(savedCustomer.getRole())
                .setAddress(savedCustomer.getAddress())
                .build();
        System.out.println("Saved Customer : " + customer);
    }

    @Test
    @Order(2)
    void b_read() {
        String url = get_URL("/read/"+savedCustomer.getUserId());
        System.out.println("URL : " + url);
        ResponseEntity <Customer> response = restTemplate.getForEntity(url,Customer.class);
        //assertEquals(customer.getUserId(),response.getBody().getUserId());
        System.out.println("READ: " + savedCustomer);
    }

    @Test
    @Order(3)
    void update() {

    }

    @Test
    @Order(4)
    void d_delete() {
        System.out.println("Customer ID to delete: " +  savedCustomer.getUserId());
        String url = get_URL("/delete/" + savedCustomer.getUserId());
        System.out.println("URL for delete: " + url);
        restTemplate.delete(url);

        // Check if the customer has been deleted
        ResponseEntity<Customer> response = restTemplate.getForEntity(get_URL("/read/" + savedCustomer.getUserId()), Customer.class);
        assertNotNull(response.getBody());
        System.out.println("Customer " + savedCustomer.getUserId() + " successfully deleted!!!");
    }

    @Test
    @Order(5)
    void e_getAll() {
        String url = get_URL("/getAll");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println("All Customers : ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
    public String get_URL(String url){
        return BASE_URL + url;
    }
}