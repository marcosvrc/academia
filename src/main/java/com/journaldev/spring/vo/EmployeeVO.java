package com.journaldev.spring.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long employeeId;
	private String employeeName;
	private Date employeeHireDate;
	private BigDecimal employeeSalary;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getEmployeeHireDate() {
		return employeeHireDate;
	}
	public void setEmployeeHireDate(Date employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}
	public BigDecimal getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(BigDecimal employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	
	
}
