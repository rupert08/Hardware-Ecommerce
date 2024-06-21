package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {

    public static Cart createCart1( Long user, Double totalPrice) {
        if (user == null || totalPrice == null || totalPrice < 0) {
            return null;
        }

        return new Cart.Builder()
                .setUserId(user)
                .setTotalPrice(totalPrice)
                .build();
    }
}

