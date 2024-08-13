package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(exclude = "category")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private float price;

    @Lob
    private Blob image;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    public Product copy() {
        return this.toBuilder().build();
    }
}
