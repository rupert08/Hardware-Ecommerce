package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentFactoryTest {

    @Test
    @Order(1)
    void createPayment() {
        Order order = new Order(); // Assume this is a valid order object
        Payment payment = PaymentFactory.createPayment(1, order, LocalDate.of(2024, 7, 23), "100.00", "Credit Card");
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    @Order(2)
    void failPayment() {
        Payment payment = PaymentFactory.createPayment(0, null, LocalDate.of(2024, 7, 23), "100.00", "Credit Card");
        assertNull(payment);
    }

    @Test
    @Order(3)
    void failPaymentDueToEmptyFields() {
        Order order = new Order(); // Assume this is a valid order object
        Payment payment = PaymentFactory.createPayment(1, order, null, "", "");
        assertNull(payment);
    }
}
