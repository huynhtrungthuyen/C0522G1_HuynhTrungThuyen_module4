package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where facility_name like %:nameSearch% and delete_status = false",
            nativeQuery = true)
    Page<Facility> searchFacility(@Param("nameSearch") String nameSearch, Pageable pageable);

    @Query(value = "select * from facility where delete_status = false", nativeQuery = true)
    List<Facility> findAll();

    @Modifying
    @Query(value = "update facility set delete_status = true where facility_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}