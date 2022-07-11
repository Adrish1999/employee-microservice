package com.adrish.spring.boot.employee.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrish.spring.boot.employee.rest.entity.Employee;
import com.adrish.spring.boot.employee.rest.service.EmployeeService;
import com.adrish.spring.boot.employee.rest.service.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public Iterable<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id")Integer id) throws EmployeeNotFoundException {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/designation/{designation}")
	public List<Employee> getEmployeeByDesignation(@PathVariable(name = "designation")String designation) {
		return employeeService.getEmployeeByDesignation(designation);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable(name = "id")Integer id, @RequestBody Employee employee) throws EmployeeNotFoundException {
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(name = "id")Integer id) {
		employeeService.removeEmployee(id);
	}
}
