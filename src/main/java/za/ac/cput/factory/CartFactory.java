package za.ac.cput.factory;

import za.ac.cput.domain.Cart;

public class CartFactory {

    public static Cart createCart1(Long user, Float totalPrice) {
        if (user == null || totalPrice == null ) {
            return null;
        }

        return new Cart.Builder()
                .setUserId(user)
                .setTotalPrice(Double.valueOf(totalPrice))
                .build();
    }
}