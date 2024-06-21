package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Shipping {
    @Id
    private long shippingID;
    private String deliveryAddress;
    private String shippingCost;
    private String orderStatus;

    public Shipping() {
    }

    public Shipping(Builder builder) {
        this.shippingID = builder.shippingID;
        this.deliveryAddress = builder.deliveryAddress;
        this.shippingCost = builder.shippingCost;
        this.orderStatus = builder.orderStatus;
    }

    public long getShippingID() {
        return shippingID;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "shippingID=" + shippingID +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", shippingCost='" + shippingCost + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipping shipping = (Shipping) o;
        return shippingID == shipping.shippingID &&
                Objects.equals(deliveryAddress, shipping.deliveryAddress) &&
                Objects.equals(shippingCost, shipping.shippingCost) &&
                Objects.equals(orderStatus, shipping.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingID, deliveryAddress, shippingCost, orderStatus);
    }

    public static class Builder {
        private long shippingID;
        private String deliveryAddress;
        private String shippingCost;
        private String orderStatus;

        public Builder setShippingID(long shippingID) {
            this.shippingID = shippingID;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setShippingCost(String shippingCost) {
            this.shippingCost = shippingCost;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder copy(Shipping shipping) {
            this.shippingID = shipping.shippingID;
            this.deliveryAddress = shipping.deliveryAddress;
            this.shippingCost = shipping.shippingCost;
            this.orderStatus = shipping.orderStatus;
            return this;
        }

        public Shipping build() {
            return new Shipping(this);
        }
    }
}
