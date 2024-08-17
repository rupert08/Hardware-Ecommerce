package za.ac.cput.factory;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import za.ac.cput.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderFactoryTest {

    private Cart createValidCart() {
        Contact contact = ContactFactory.createContact("john.doe@example.com", "0783139988");
        Customer customer = CustomerFactory.createCustomer1(contact.getEmail(), "123456", "Customer");
        return CartFactory.createCart(customer);
    }

    private Shipping createValidShipping() {
        Address address = AddressFactory.createAddress("21", "", "", "", "", "Main Street", "Capetown", "Western Cape", "8008");
        return ShippingFactory.createShipping(address, OrderStatus.PENDING, 50.0f);
    }

    @Test
    @org.springframework.core.annotation.Order(1)
    void testBuildOrderWithAllFields() {
        Cart cart = createValidCart();
        Shipping shipping = createValidShipping();
        LocalDate orderDate = LocalDate.now();
        float totalAmount = 500.0f;
        String orderStatus = "Pending";

        Order order =  OrderFactory.buildOrder(cart, orderDate, shipping, totalAmount, orderStatus);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    @org.springframework.core.annotation.Order(2)
    void testBuildOrderWithEmptyOrderItems() {
        Cart cart = createValidCart();
        Shipping shipping = createValidShipping();
        LocalDate orderDate = LocalDate.now();
        float totalAmount = 500.0f;
        String orderStatus = null;

        Order order = (Order) OrderFactory.buildOrder(cart, orderDate, shipping, totalAmount, orderStatus);
        assertNotNull(order);
        System.out.println(order);
    }
}