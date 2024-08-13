package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;
import java.time.LocalDate;
import java.util.Set;

public class OrderFactory {

    public static Order buildOrder(long userID, LocalDate orderDate, Address address, float totalAmount, String orderStatus) {
        if (Helper.isNullOrEmpty(String.valueOf(userID)) || Helper.isNullOrEmpty(String.valueOf(orderDate))
                || Helper.isNullOrEmpty(String.valueOf(address)) || Helper.isNullOrEmpty(String.valueOf(totalAmount))
                || Helper.isNullOrEmpty(orderStatus) ) {
            return null;
        }

        return new Order.Builder()
                .setUserID(userID)
                .setOrderDate(orderDate)
                .setDeliveryAddress(address)
                .setTotalAmount(totalAmount)
                .setOrderStatus(orderStatus)
                .build();
    }
}

