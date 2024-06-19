package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;

import java.math.BigDecimal;

public class ProductFactory {

    public static Product createProduct(String name, BigDecimal price, String image, String description, int inventory, Category category) {
        if (name == null || name.isEmpty() || price == null || price.compareTo(BigDecimal.ZERO) <= 0 || image == null || image.isEmpty() || description == null || description.isEmpty() || inventory < 0 || category == null) {
            throw new IllegalArgumentException("Invalid input values");
        }

        return new Product.Builder()
                .setName(name)
                .setPrice(price)
                .setImage(image)
                .setDescription(description)
                .setInventory(inventory)
                .setCategory(category)
                .build();
    }
}