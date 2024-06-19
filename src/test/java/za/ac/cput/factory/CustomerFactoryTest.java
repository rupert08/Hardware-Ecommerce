package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerFactoryTest {
    Contact contact = ContactFactory.createContact("john@gmail.com","02189456123");
    @Test
    @Order(1)
    void a_customerLoginDetails_success() {
        Customer customer = CustomerFactory.createCustomer1(contact.getEmail(), contact.getPhoneNumber(),"Customer") ;

        assertNotNull(customer);
        System.out.println(customer);
    }
    @Test
    @Order(2)
    void b_customerLoginDetails_failed() {
        Customer customer = CustomerFactory.createCustomer1("fakeMail.com", " ","Customer") ;

        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(3)
    void c_customerRegisterDetails_Success() {
        Address address = AddressFactory.createAddress("21","","","",
                "","Moses","Capetown","Western Cape","8008");
        assertNotNull(address);
        Customer customer = CustomerFactory.createCustomer2("John","Wick",contact,"123456","Customer",address) ;

        assertNotNull(customer);
        System.out.println(customer);
    }
    @Test
    @Order(4)
    void d_customerRegisterDetails_failed() {
        Address address = AddressFactory.createAddress("12","","","",
                "","Moses","Capetown","Western Cape","8008");
        Customer customer = CustomerFactory.createCustomer2("","Moses",contact,"123456","Customer",address) ;

        assertNotNull(customer);
        System.out.println(customer);
    }
}