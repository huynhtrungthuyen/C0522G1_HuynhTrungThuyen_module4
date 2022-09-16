package product_management.service;

import product_management.model.Product;

import java.util.List;

public interface IProductManagementService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
