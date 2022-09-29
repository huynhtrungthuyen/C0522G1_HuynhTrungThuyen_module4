package com.example.service.employee.impl;

import com.example.model.employee.Employee;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteLogical(Integer id) {
        iEmployeeRepository.deleteLogical(id);
    }

    @Override
    public Page<Employee> searchEmployee(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return iEmployeeRepository.searchEmployee(nameSearch, addressSearch, phoneSearch, pageable);
    }
}
