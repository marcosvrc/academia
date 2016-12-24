package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.journaldev.spring.service.interfaces.EmployeeService;
import com.journaldev.spring.vo.EmployeeVO;

@Controller("registerEmployeeMbean")
@Scope("session")
public class RegisterEmployeeMbean {

	private EmployeeService employeeService;

	@Autowired
	public RegisterEmployeeMbean(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	private EmployeeVO employee = new EmployeeVO();
	public EmployeeVO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeVO employee) {
		this.employee = employee;
	}

	public String register() {
		// Calling Business Service
		employeeService.register(employee);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getEmployeeName()+" Is Registered Successfully"));
		return "";
	}
}
