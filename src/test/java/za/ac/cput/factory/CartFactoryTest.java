package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;

import static org.junit.jupiter.api.Assertions.*;

public class CartFactoryTest {

    @Test
    void testCreateCartWithValidFields() {
        Cart cart = CartFactory.createCart1(1234567L, 450.75);
        assertNotNull(cart);
        assertEquals(1234567L, cart.getUserId());
        assertEquals(450.75, cart.getTotalPrice());
        System.out.println(cart);
    }

    @Test
    void testCreateCartWithNullUser() {
        Cart cart = CartFactory.createCart1(null, 450.75);
        assertNull(cart);
    }

    @Test
    void testCreateCartWithNullTotalPrice() {
        Cart cart = CartFactory.createCart1(1234567L, null);
        assertNull(cart);
    }

    @Test
    void testCreateCartWithNegativeTotalPrice() {
        Cart cart = CartFactory.createCart1(1234567L, -99.99);
        assertNull(cart);
    }

    @Test
    void testCreateCartWithZeroTotalPrice() {
        Cart cart = CartFactory.createCart1(7654321L, 0.0);
        assertNotNull(cart);
        assertEquals(7654321L, cart.getUserId());
        assertEquals(0.0, cart.getTotalPrice());
        System.out.println(cart);
    }
}