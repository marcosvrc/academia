package com.journaldev.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.spring.dao.interfaces.EmployeeDAO;
import com.journaldev.spring.service.interfaces.EmployeeService;
import com.journaldev.spring.vo.EmployeeVO;
import com.journaldev.spring.vo.converter.Converter;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired(required=true)
	private EmployeeDAO dao;
	
	@Transactional
	public void register(EmployeeVO emp) {
		dao.register(Converter.converterVoParaEmployee(emp));
	}
}
