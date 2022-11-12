package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product " +
            "where product_name like %:nameSearch% and product_price like %:priceSearch% and is_delete = false",
            nativeQuery = true)
    Page<Product> searchProduct(@Param("nameSearch") String nameSearch,
                                @Param("priceSearch") String priceSearch,
                                Pageable pageable);

    @Modifying
    @Query(value = "update product set is_delete = true where product_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
