package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;

public class ProductFactory {

    public static Product createProduct(String name, String description, float price, String imagePath, Category category) throws Exception {
        Blob imageBlob = null;
       if (Helper.isNullOrEmpty(name)){
           throw new Exception("Trying to create a Product with null or empty name!!!");
       }if (Helper.isNullOrEmpty(description)){
           description = "No description provided";
        }

       if(!Helper.isNullOrEmpty(name) && Helper.isNullOrEmpty(String.valueOf(category))){
           throw new Exception("Category name is null or empty, cannot create product without a category");
       }
       if(!Helper.isNullOrEmpty(name) && Helper.isNullOrEmpty(String.valueOf(price))){
           throw new Exception("Price is null or empty, cannot create product without a valid price");
       }
        if (!Helper.isNullOrEmpty(imagePath)) {
            try {
                byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
                imageBlob = new SerialBlob(imageBytes);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read Product image file: " + imagePath, e);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to create Blob from image bytes", e);
            }
        }
       else {
            imagePath = "Image path for "+name+" product was null or empty";
            System.out.println(imagePath);
        }

        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .image(imageBlob)
                .category(category)
                .build();
    }
//    public static Product createProductWithoutImage(String name, String description, float price, Category category) {
//        return Product.builder()
//                .name(name)
//                .description(description)
//                .price(price)
//                .image(null)
//                .category(category)
//                .build();
//    }
}