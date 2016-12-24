package com.journaldev.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.journaldev.jpa.data.Employee;
import com.journaldev.spring.dao.interfaces.EmployeeDAO;

@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO{
	
	@Override
	public void register(Employee emp) {
		super.getEntityManager().persist(emp);
		
	}

}
