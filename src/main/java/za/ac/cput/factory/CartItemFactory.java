package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;

public class CartItemFactory {

    public static CartItem createCartItem(Long cartItemID, Long productID, Integer quantity, Cart cart) {

        if (cartItemID == null || productID == null || quantity == null || quantity <= 0 || cart == null) {
            return null;
        }


        return new CartItem.Builder()
                .setCartItemID(cartItemID)
                .setProductID(productID)
                .setQuantity(quantity)
                .setCart(cart)
                .build();
    }
}


