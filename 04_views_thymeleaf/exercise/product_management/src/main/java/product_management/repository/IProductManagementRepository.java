package product_management.repository;

import product_management.model.Product;

import java.util.List;

public interface IProductManagementRepository  {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
