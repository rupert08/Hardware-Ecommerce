package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.factory.CustomerFactory.createCustomer1;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerFactoryTest {

    Contact contact = ContactFactory.createContact("john@gmail.com","0218945600");
    Address address = AddressFactory.createAddress("21","","","",
            "","Moses","Capetown","Western Cape","8008");
    Customer customer = CustomerFactory.createCustomer2(contact.getEmail(), "John","Wick",contact,"123456","Customer",address) ;


    @Test
    @Order(1)
    void a_customerLoginDetails_success() {
        Customer customer1 = CustomerFactory.createCustomer1(customer.getUsername(), customer.getPassword(), customer.getRole()) ;
        assertEquals(customer.getUsername(), customer1.getUsername());
        assertNotNull(customer1);
        System.out.println(customer1);
    }
    @Test
    @Order(2)
    void b_customerLoginDetails_failed() {
        Customer customer2 = CustomerFactory.createCustomer1("fakeMail.com", "12345","Customer") ;
        assertNotNull(customer2);
        System.out.println(customer2);
    }

    @Test
    @Order(3)
    void c_customerRegisterDetails_Success() {
        Address address = AddressFactory.createAddress("21","","","",
                "","Moses","Capetown","Western Cape","8008");
        assertNotNull(address);
        Customer customer = CustomerFactory.createCustomer2(contact.getEmail(), "John","Wick",contact,"123456","Customer",address) ;

        assertNotNull(customer);
        System.out.println(customer);
    }
    @Test
    @Order(4)
    void d_customerRegisterDetails_failed() {
       Address addressF = AddressFactory.createAddress("21","2","","",
               "","Moses","Capetown","Western Cape","231");
       Customer customer3 = CustomerFactory.createCustomer2(contact.getEmail(), "John","Moses",contact,"123456","Customer",addressF) ;

        assertNotNull(customer3);
        System.out.println(customer3);
    }
}