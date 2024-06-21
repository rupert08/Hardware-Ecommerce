package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(long paymentID, Order order, LocalDate localDate, String amount, String method) {

        if (paymentID <= 0 || order == null || Helper.isNullOrEmpty(String.valueOf(localDate)) ||
                Helper.isNullOrEmpty(amount) || Helper.isNullOrEmpty(method)) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setOrder(order)
                .setLocalDate(localDate)
                .setAmount(amount)
                .setMethod(method)
                .build();
    }
}
