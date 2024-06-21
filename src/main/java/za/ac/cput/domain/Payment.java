package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    private long paymentID;

    @OneToOne
     @JoinColumn(name = "orderID")
    private Order order;

    private LocalDate localDate;
    private String amount;
    private String method;

    public Payment() {
    }

    public Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.order = builder.order;
        this.localDate = builder.localDate;
        this.amount = builder.amount;
        this.method = builder.method;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", order=" + order +
                ", localDate=" + localDate +
                ", amount='" + amount + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentID == payment.paymentID &&
                Objects.equals(order, payment.order) &&
                Objects.equals(localDate, payment.localDate) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(method, payment.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, order, localDate, amount, method);
    }

    public static class Builder {
        private long paymentID;
        private Order order;
        private LocalDate localDate;
        private String amount;
        private String method;

        public Builder setPaymentID(long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public Builder setAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentID = payment.paymentID;
            this.order = payment.order;
            this.localDate = payment.localDate;
            this.amount = payment.amount;
            this.method = payment.method;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}


