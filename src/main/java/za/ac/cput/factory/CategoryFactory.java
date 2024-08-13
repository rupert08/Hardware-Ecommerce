package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import javax.sql.rowset.serial.SerialBlob;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
public class CategoryFactory {

    public static Category createCategory(String name, String description, String imagePath, Set<Product> products) throws Exception {
       Blob imageBlob = null;
        if (imagePath != null && !imagePath.isEmpty()) {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            imageBlob = new SerialBlob(imageBytes);
        }
        else {

            imagePath = "image not found or invalid path";
            System.out.println(imagePath);

        }

        if(Helper.isNullOrEmpty(name)){
            throw new Exception("Category name cannot be null/empty");
        }
        if(Helper.isNullOrEmpty(description)){
            description = "no description";
        }

        if(Helper.isNullOrEmpty(String.valueOf(products))){
            products = new HashSet<>();
        }

        Category category = Category.builder()
                .name(name)
                .description(description)
                .image(imageBlob)
                .products(products)
                .build();
//        if (products != null) {
//            for (Product product : products) {
//                category.addProduct(product);
//            }
//        }
        return category;
    }
    public static Category createCategoryWithoutProducts(String name, String description, String imagePath) throws Exception {
        return createCategory(name, description, imagePath, new HashSet<>());
    }

}