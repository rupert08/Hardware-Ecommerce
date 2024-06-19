package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;
    private String name;
    private String description;

    protected Category() {}

    private Category(Builder builder) {
        this.categoryID = builder.categoryID;
        this.name = builder.name;
        this.description = builder.description;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private Long categoryID;
        private String name;
        private String description;

        public Builder setCategoryID(Long categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Category category) {
            this.categoryID = category.categoryID;
            this.name = category.name;
            this.description = category.description;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryID, category.categoryID) &&
                Objects.equals(name, category.name) &&
                Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, name, description);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
