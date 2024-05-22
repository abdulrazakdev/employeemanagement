package com.mouhcine.SpringBootAPiEmployeeManagement.core.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.bo.Employee;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping("employees")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id).get();
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@PutMapping("employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		Employee emp = employeeService.getEmployeeById(id).get();
		emp.setAge(employee.getAge());
		emp.setEmail(employee.getEmail());
		emp.setFullName(employee.getFullName());
		emp.setPhoneNumber(employee.getPhoneNumber());
		return employeeService.update(emp);
	}

	@DeleteMapping("employees/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return "Delete successFully";
	}

//	@PostConstruct
//	public String  gggg() {
//		System.out.println("TESTINGNNN");
//		return "  RUNNING ";
//		
//	}
}
