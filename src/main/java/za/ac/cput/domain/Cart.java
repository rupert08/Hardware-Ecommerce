package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString/*(exclude = {"cartItems"})*/
@EqualsAndHashCode
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id") // Adjusted column name for consistency
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartItem> cartItems = new ArrayList<>();

    private int itemsQuantity = 0;
    private float totalPrice = 0.0f;

    public void addCartItem(CartItem cartItem) {
        if (cartItem == null || cartItem.getCart() != this) {
            throw new IllegalArgumentException("Invalid CartItem or CartItem does not belong to this Cart.");
        }
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
        calculateTotals();
    }

    public void removeCartItem(CartItem cartItem) {
        if (cartItems.remove(cartItem)) {
            cartItem.setCart(null);
            calculateTotals();
        }
    }

    public void calculateTotals() {
        itemsQuantity = 0;
        totalPrice = 0.0f;
        for (CartItem cartItem : cartItems) {
            itemsQuantity += cartItem.getQuantity();
            totalPrice += cartItem.getItemTotalPrice();
        }
        totalPrice = roundToTwoDecimalPlaces(totalPrice);
    }
    // To Make sure the float returns only 2 decimal places to the right
    private float roundToTwoDecimalPlaces(float value) {
        BigDecimal bd = new BigDecimal(Float.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
