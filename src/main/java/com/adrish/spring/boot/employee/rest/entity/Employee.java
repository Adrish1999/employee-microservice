package com.adrish.spring.boot.employee.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adrish.spring.boot.employee.rest.utility.EmployeeUtility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name=EmployeeUtility.EMP_TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@Column(name=EmployeeUtility.EMP_ID)
	private Integer empId;
	@Column(name=EmployeeUtility.EMP_NAME)
	private String name;
	@Column(name=EmployeeUtility.EMP_DESIGNATION)
	private String designation;
	@Column(name=EmployeeUtility.EMP_DATE_OF_BIRTH)
	private Date dateOfBirth;
	@Column(name=EmployeeUtility.EMP_MANAGER_ID)
	private Integer managerId;
	@Column(name=EmployeeUtility.EMP_SALARY)
	private Integer salary;
	@Column(name=EmployeeUtility.EMP_DEPARTMENT_ID)
	private Integer deptId;
}
