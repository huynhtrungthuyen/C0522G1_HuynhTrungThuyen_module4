package product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import product_management.model.Product;

import java.util.List;

public interface IProductManagementRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);

//    List<Product> findByNameContaining(String name);
    @Query(value = "select * from Product where name like %:keyword%", nativeQuery = true)
    List<Product> searchByName(@Param("keyword") String name);
}
