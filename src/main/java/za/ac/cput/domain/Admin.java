package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(callSuper = true)
public class Admin extends User implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactId", referencedColumnName = "contactId")
    private Contact contact;

    // Methods to manage features
    public void manageCustomer(Customer customer) {
        // Implementation for managing customer
    }

    public void manageOrder(Order order) {
        // Implementation for managing order
    }

    public void manageProduct(Product product) {
        // Implementation for managing product
    }

    public void manageCategory(Category category) {
        // Implementation for managing category
    }

    public void manageShipping(Shipping shipping) {
        // Implementation for managing shipping
    }
}