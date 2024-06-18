package za.ac.cput.factory;

import za.ac.cput.domain.Shipping;
import za.ac.cput.util.Helper;

public class ShippingFactory {

    public static Shipping createShipping(long shippingID, String deliveryAddress, String shippingCost, String orderStatus) {

        if (shippingID <= 0 || Helper.isNullOrEmpty(deliveryAddress) || Helper.isNullOrEmpty(shippingCost) || Helper.isNullOrEmpty(orderStatus)) {
            return null;
        }

        return new Shipping.Builder()
                .setShippingID(shippingID)
                .setDeliveryAddress(deliveryAddress)
                .setShippingCost(shippingCost)
                .setOrderStatus(orderStatus)
                .build();
    }
}
