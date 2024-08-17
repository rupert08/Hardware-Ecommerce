// Order.java
package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity
@Table(name = "`order`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;

    @OneToOne
    @JoinColumn(name = "cartID")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "shippingID")
    private Shipping shipping;

    private LocalDate orderDate;
    private BigDecimal totalAmount;
    private String orderStatus;

    public void calculateTotalAmount() {
        if (cart != null) {
            totalAmount = cart.getTotalPrice();
        } else {
            totalAmount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
    }
}