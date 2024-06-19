package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryFactoryTest {

    @Test
    public void testCreateCategory() {
        Category category = CategoryFactory.createCategory("Electronics", "Devices and gadgets");
        assertNotNull(category);
        assertEquals("Electronics", category.getName());
        assertEquals("Devices and gadgets", category.getDescription());
    }

    @Test
    public void testCreateCategoryWithInvalidInputs() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CategoryFactory.createCategory("", "");
        });
        assertEquals("Name and Description cannot be null or empty", exception.getMessage());
    }
}