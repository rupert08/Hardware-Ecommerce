package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;
    private long userID;
    private LocalDate orderDate;
    @Embedded
    private Address address;
    private float totalAmount;
    private String orderStatus;

    protected Order() {
    }

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.userID = builder.userID;
        this.orderDate = builder.orderDate;
        this.address = builder.address;
        this.totalAmount = builder.totalAmount;
        this.orderStatus = builder.orderStatus;
    }

    public long getOrderID() {
        return orderID;
    }

    public long getUserID() {
        return userID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Address getDeliveryAddress() {
        return address;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderID, order.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", orderDate=" + orderDate +
                ", deliveryAddress=" + address +
                ", totalAmount=" + totalAmount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public static class Builder {
        private long orderID;
        private long userID;
        private LocalDate orderDate;
        private Address address;
        private float totalAmount;
        private String orderStatus;

        public Builder setOrderID(long orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setUserID(long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setDeliveryAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setTotalAmount(float totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder copy(Order order) {
            this.orderID = order.orderID;
            this.userID = order.userID;
            this.orderDate = order.orderDate;
            this.address = order.address;
            this.totalAmount = order.totalAmount;
            this.orderStatus = order.orderStatus;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
