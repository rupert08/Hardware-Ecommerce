package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class CartItem implements Serializable {

    @Id
    private Long cartItemID;
    private Long productID;
    @ManyToOne
    @JoinColumn(name = "CartId", nullable = false)
    private Cart cart;
    private int quantity;
    private double price;



    protected CartItem() {
    }

    public CartItem(Builder builder) {
        this.cartItemID = builder.cartItemID;
        this.productID = builder.productID;
        this.cart = builder.cart;
        this.quantity = builder.quantity;
        this.price = builder.price;

    }

    public Long getCartItemID() {
        return cartItemID;
    }

    public Long getProductID() {
        return productID;
    }

    public Cart getCart() {return cart;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public double getPrice() {return price;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity && Double.compare(price, cartItem.price) == 0 && Objects.equals(cartItemID, cartItem.cartItemID) && Objects.equals(productID, cartItem.productID) && Objects.equals(cart, cartItem.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemID, productID, cart, quantity, price);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemID=" + cartItemID +
                ", productID=" + productID +
                ", cart=" + cart +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Long cartItemID;
        private Long productID;
        private Cart cart;
        private int quantity;
        private double price;

        public Builder setCartItemID(Long cartItemID) {
            this.cartItemID = cartItemID;
            return this;
        }

        public Builder setProductID(Long productID) {
            this.productID = productID;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemID = cartItem.getCartItemID();
            this.productID = cartItem.getProductID();
            this.cart = cartItem.getCart();
            this.quantity = cartItem.getQuantity();
            this.price = cartItem.getPrice();
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}

