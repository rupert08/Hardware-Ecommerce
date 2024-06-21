package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemFactoryTest {

    @Test
    void testCreateCartItemWithValidFields() {
        Cart cart = new Cart.Builder().setUserId(1234567L).setTotalPrice(300.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(9876543L, 1234567L, 5, cart);
        assertNotNull(cartItem);
        assertEquals(9876543L, cartItem.getCartItemID());
        assertEquals(1234567L, cartItem.getProductID());
        assertEquals(5, cartItem.getQuantity());
        assertEquals(cart, cartItem.getCart());
        System.out.println(cartItem);
    }

    @Test
    void testCreateCartItemWithNullCartItemID() {
        Cart cart = new Cart.Builder().setUserId(1234567L).setTotalPrice(300.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(null, 1234567L, 5, cart);
        assertNull(cartItem);
    }

    @Test
    void testCreateCartItemWithNullProductID() {
        Cart cart = new Cart.Builder().setUserId(1234567L).setTotalPrice(300.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(9876543L, null, 5, cart);
        assertNull(cartItem);
    }

    @Test
    void testCreateCartItemWithNullQuantity() {
        Cart cart = new Cart.Builder().setUserId(1234567L).setTotalPrice(300.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(9876543L, 1234567L, null, cart);
        assertNull(cartItem);
    }

    @Test
    void testCreateCartItemWithZeroQuantity() {
        Cart cart = new Cart.Builder().setUserId(1234567L).setTotalPrice(300.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(9876543L, 1234567L, 0, cart);
        assertNull(cartItem);
    }

    @Test
    void testCreateCartItemWithNegativeQuantity() {
        Cart cart = new Cart.Builder().setUserId(1234567L).setTotalPrice(300.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(9876543L, 1234567L, -1, cart);
        assertNull(cartItem);
    }

    @Test
    void testCreateCartItemWithNullCart() {
        CartItem cartItem = CartItemFactory.createCartItem(9876543L, 1234567L, 5, null);
        assertNull(cartItem);
    }

    @Test
    void testCreateCartItemWithDifferentValidFields() {
        Cart cart = new Cart.Builder().setUserId(7654321L).setTotalPrice(150.0).build();
        CartItem cartItem = CartItemFactory.createCartItem(11121314L, 9876543L, 3, cart);
        assertNotNull(cartItem);
        assertEquals(11121314L, cartItem.getCartItemID());
        assertEquals(9876543L, cartItem.getProductID());
        assertEquals(3, cartItem.getQuantity());
        assertEquals(cart, cartItem.getCart());
        System.out.println(cartItem);
    }
}