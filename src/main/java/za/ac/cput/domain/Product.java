package za.ac.cput.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    private String name;
    private BigDecimal price;
    private String image;
    private String description;
    private int inventory;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    protected Product() {}

    private Product(Builder builder) {
        this.productID = builder.productID;
        this.name = builder.name;
        this.price = builder.price;
        this.image = builder.image;
        this.description = builder.description;
        this.inventory = builder.inventory;
        this.category = builder.category;
    }

    public Long getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getInventory() {
        return inventory;
    }

    public Category getCategory() {
        return category;
    }

    public static class Builder {
        private Long productID;
        private String name;
        private BigDecimal price;
        private String image;
        private String description;
        private int inventory;
        private Category category;

        public Builder setProductID(Long productID) {
            this.productID = productID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setInventory(int inventory) {
            this.inventory = inventory;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder copy(Product product) {
            this.productID = product.productID;
            this.name = product.name;
            this.price = product.price;
            this.image = product.image;
            this.description = product.description;
            this.inventory = product.inventory;
            this.category = product.category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return inventory == product.inventory &&
                Objects.equals(productID, product.productID) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(image, product.image) &&
                Objects.equals(description, product.description) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, price, image, description, inventory, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", inventory=" + inventory +
                ", category=" + category +
                '}';
    }
}
