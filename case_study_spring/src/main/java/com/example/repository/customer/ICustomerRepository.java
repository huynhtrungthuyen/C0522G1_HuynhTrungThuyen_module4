package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where delete_status = false", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Query(value = "select * from customer where customer_name like %:nameSearch% and " +
            "customer_address like %:addressSearch% and customer_phone like %:phoneSearch% and delete_status = false",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch, @Param("addressSearch") String addressSearch,
                                  @Param("phoneSearch") String phoneSearch, Pageable pageable);

    @Modifying
    @Query(value = "update customer set delete_status = true where customerId = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
