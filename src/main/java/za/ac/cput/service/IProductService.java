package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.util.Set;

public interface IProductService {
    Product create(Product product);
    Product read(Long id);
    Product update(Product product);
    void delete(Long id);
    Set<Product> getAll();
}