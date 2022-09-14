package product_management.repository.impl;

import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.IProductManagementRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductManagementRepository implements IProductManagementRepository {
    private static final Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Vang ma", 50000, "no", "ThuiVy-DaiLoi company"));
        productList.put(2, new Product(2, "Trung ga", 5000, "no", "ThuiVy-DaiLoi company"));
        productList.put(3, new Product(3, "Mi tom", 3000, "no", "ThuiVy-DaiLoi company"));
        productList.put(4, new Product(4, "Banh trung thu", 15000, "no", "ThuiVy-DaiLoi company"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();

        for (Product item : productList.values()) {
            if (item.getName().contains(name)) {
                products.add(item);
            }
        }

        return products;
    }
}