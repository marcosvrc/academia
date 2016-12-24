package com.journaldev.spring.vo.converter;

import com.journaldev.jpa.data.Employee;
import com.journaldev.spring.vo.EmployeeVO;

public class Converter {

	public static Employee converterVoParaEmployee(EmployeeVO empVO){
		Employee employee = new Employee();
		employee.setEmployeeHireDate(empVO.getEmployeeHireDate());
		employee.setEmployeeId(empVO.getEmployeeId());
		employee.setEmployeeName(empVO.getEmployeeName());
		employee.setEmployeeSalary(empVO.getEmployeeSalary());
		return employee;
	}
	
	
	
}
