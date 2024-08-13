package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerServiceTest {
    @Autowired
    CustomerService customerService;
    private static Contact contact = ContactFactory.createContact("john1@gmail.com","02189456123");
    private static Address address = AddressFactory.createAddress("21","","","",
            "","Moses","Capetown","Western Cape","7646");

    private static Customer customer = CustomerFactory.createCustomer2(contact.getEmail(), "John","Wick",contact,"123456","Customer",address);

    @Test
    void a_create() {

        Customer created = customerService.create(customer);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Customer read = customerService.read(customer.getUserId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Customer newCustomer = new Customer.Builder().copy(customer).setFirstName("Johnathan").build();
        Customer updated = customerService.update(newCustomer);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete() {
        customerService.delete(customer.getUserId());
        System.out.println("Customer Deleted Where User ID = "+ customer.getUserId() );
    }

    @Test
    void e_getAll() {
        System.out.println(customerService.getAll());
    }
}