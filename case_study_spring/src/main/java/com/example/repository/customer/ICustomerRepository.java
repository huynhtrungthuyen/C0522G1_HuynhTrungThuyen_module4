package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer_name like %:nameSearch% and " +
            "customer_address like %:addressSearch% and customer_phone like %:phoneSearch% and delete_status = false",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch, @Param("addressSearch") String addressSearch,
                                  @Param("phoneSearch") String phoneSearch, Pageable pageable);

    @Query(value = "select * from customer where delete_status = false", nativeQuery = true)
    List<Customer> findAll();

    @Modifying
    @Query(value = "update customer set delete_status = true where customer_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
