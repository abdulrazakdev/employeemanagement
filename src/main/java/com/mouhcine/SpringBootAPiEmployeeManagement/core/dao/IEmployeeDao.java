package com.mouhcine.SpringBootAPiEmployeeManagement.core.dao;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.bo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeDao extends JpaRepository<Employee,Long> {
    public Optional<Employee> findById(Long id);

}
