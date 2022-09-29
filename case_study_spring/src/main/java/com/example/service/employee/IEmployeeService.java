package com.example.service.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> findById(Integer id);

    void update(Employee employee);

    void deleteLogical(Integer id);

    Page<Employee> searchEmployee(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);
}
