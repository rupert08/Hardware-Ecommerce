package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFactoryTest {

    @Test
    public void testCreateProduct() {
        Category category = CategoryFactory.createCategory("Electronics", "Devices and gadgets");
        Product product = ProductFactory.createProduct("Smartphone", BigDecimal.valueOf(699.99), "image_url", "Latest smartphone", 100, category);

        assertNotNull(product);
        assertEquals("Smartphone", product.getName());
        assertEquals(BigDecimal.valueOf(699.99), product.getPrice());
        assertEquals("image_url", product.getImage());
        assertEquals("Latest smartphone", product.getDescription());
        assertEquals(100, product.getInventory());
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testCreateProductWithInvalidInputs() {
        Category category = CategoryFactory.createCategory("Electronics", "Devices and gadgets");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct("", BigDecimal.ZERO, "", "", -1, category);
        });
        assertEquals("Invalid input values", exception.getMessage());
    }
}