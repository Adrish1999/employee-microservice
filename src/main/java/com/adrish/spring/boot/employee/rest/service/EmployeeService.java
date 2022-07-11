package com.adrish.spring.boot.employee.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrish.spring.boot.employee.rest.entity.Employee;
import com.adrish.spring.boot.employee.rest.repository.EmployeeRepository;
import com.adrish.spring.boot.employee.rest.service.exception.EmployeeNotFoundException;
import com.adrish.spring.boot.employee.rest.utility.EmployeeUtility;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Transactional
	public List<Employee> getAllEmployees() {
		/*
		 * Business logic to retrieve record of all employees from the database
		 */
		return employeeRepository.findAll();
	}

	@Transactional
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {
		/*
		 * Business logic to retrieve record of a specific employee using employee Id
		 */
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("No Employee found with id " + employeeId);
		}
		return employee.get();
	}

	@Transactional
	public Employee addEmployee(Employee employee) {
		/*
		 * Business logic to insert new employee record in the database
		 */
		return employeeRepository.save(employee);
	}

	@Transactional
	public Employee updateEmployee(Employee employee, int employeeId) throws EmployeeNotFoundException {
		/*
		 * Business logic to update a specific employee record using employee Id
		 */
		Optional<Employee> retrievedEmployee = employeeRepository.findById(employeeId);
		if (!retrievedEmployee.isPresent()) {
			throw new EmployeeNotFoundException("No Employee found with id " + employeeId);
		}
		Employee emp = retrievedEmployee.get();
		emp.setName(employee.getName());
		emp.setDesignation(employee.getDesignation());
		emp.setDateOfBirth(EmployeeUtility.getSqlDate(employee.getDateOfBirth()));
		emp.setManagerId(employee.getManagerId());
		emp.setSalary(employee.getSalary());
		emp.setDeptId(employee.getDeptId());
		return employeeRepository.save(emp);
	}

	@Transactional
	public void removeEmployee(int employeeId) {
		/*
		 * Business logic to delete a specific employee record using employee Id
		 */
		employeeRepository.deleteById(employeeId);
	}
	
	@Transactional
	public List<Employee> getEmployeeByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	public void displayEmployees(List<Employee> employees) {
		/*
		 * Business logic to log employee details
		 */
		logger.info("Displaying All Employees....");
		for (Employee emp : employees) {
			logger.debug("Employee:{}",emp);
		}
	}
}
