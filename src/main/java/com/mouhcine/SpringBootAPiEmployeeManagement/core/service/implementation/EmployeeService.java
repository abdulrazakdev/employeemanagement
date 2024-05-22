package com.mouhcine.SpringBootAPiEmployeeManagement.core.service.implementation;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.bo.Employee;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.dao.IEmployeeDao;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeDao employeeDao;
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        employeeDao.deleteById(id);
    }
}
