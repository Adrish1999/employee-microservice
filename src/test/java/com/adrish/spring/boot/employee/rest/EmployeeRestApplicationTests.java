package com.adrish.spring.boot.employee.rest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adrish.spring.boot.employee.rest.entity.Employee;
import com.adrish.spring.boot.employee.rest.service.EmployeeService;
import com.adrish.spring.boot.employee.rest.service.exception.EmployeeNotFoundException;
import com.adrish.spring.boot.employee.rest.utility.EmployeeUtility;

@SpringBootTest
class EmployeeRestApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	void saveEmployeeTest() throws EmployeeNotFoundException {
		Employee employee = new Employee();
		employee.setEmpId(16);
		employee.setName("Batty");
		employee.setDesignation("Clerk");
		Date dateOfBirth = EmployeeUtility.getUtilDate("1997-09-23");
		employee.setDateOfBirth(dateOfBirth);
		employee.setManagerId(3);
		employee.setSalary(21500);
		employee.setDeptId(3);
		employeeService.addEmployee(employee);
		assertNotNull(employeeService.getEmployeeById(16));
	}

	@Test
	void getEmployeeByIdTest() throws EmployeeNotFoundException {
		assertNotNull(employeeService.getEmployeeById(1));
	}
	
	@Test
	void getEmployeeByDesignationTest() {
		List<Employee> employeesList = employeeService.getEmployeeByDesignation("President");
		assertNotEquals(0, employeesList.size());
	}
}
