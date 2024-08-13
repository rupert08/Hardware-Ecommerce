package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString(exclude = "cart")
@EqualsAndHashCode
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cartId", nullable = false)
    private Cart cart;

    @Column(nullable = false)
    private int quantity;

    private float itemTotalPrice;

    public void calculateItemTotalPrice() {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can not be less than zero.");
        }
        if (product != null) {
            this.itemTotalPrice = product.getPrice() * quantity;
        } else {
            this.itemTotalPrice = 0;
        }
    }
}
