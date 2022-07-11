package com.adrish.spring.boot.employee.rest.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeUtility {
	/*
	 * employee table column names
	 */
	public static final String EMP_TABLE_NAME = "employee";
	public static final String EMP_ID = "emp_id";
	public static final String EMP_NAME = "name";
	public static final String EMP_DESIGNATION = "designation";
	public static final String EMP_DATE_OF_BIRTH = "date_of_birth";
	public static final String EMP_MANAGER_ID = "manager_id";
	public static final String EMP_SALARY = "salary";
	public static final String EMP_DEPARTMENT_ID = "dept_id";
	
	private EmployeeUtility() {
	    throw new IllegalStateException("Employee Utility class");
	}
	
	public static java.util.Date getUtilDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return utilDate;
	}
	
	public static java.sql.Date getSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
