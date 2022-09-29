package com.example.repository.employee;

import com.example.model.employee.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Divisions, Integer> {
}
