package za.ac.cput.factory;

import za.ac.cput.domain.Category;

public class CategoryFactory {

    public static Category createCategory(String name, String description) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Name and Description cannot be null or empty");
        }
        return new Category.Builder()
                .setName(name)
                .setDescription(description)
                .build();
    }
}