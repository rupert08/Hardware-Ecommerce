package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Shipping;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShippingFactoryTest {

    @Test
    @Order(1)
    void createShipping() {
        Shipping shipping = ShippingFactory.createShipping(1, "123 Main St, Springfield", "15.00", "Processing");
        assertNotNull(shipping);
        System.out.println(shipping);
    }

    @Test
    @Order(2)
    void failShipping() {
        Shipping shipping = ShippingFactory.createShipping(0, null, "15.00", "Processing");
        assertNull(shipping);
    }

    @Test
    @Order(3)
    void failShippingDueToEmptyFields() {
        Shipping shipping = ShippingFactory.createShipping(1, "", "", "");
        assertNull(shipping);
    }
}
