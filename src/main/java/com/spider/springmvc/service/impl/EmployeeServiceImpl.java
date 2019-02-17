package com.spider.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.springmvc.dao.EmployeeDAO;
import com.spider.springmvc.domain.Employee;
import com.spider.springmvc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired(required = false)
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO EmployeeDAO) {
		this.employeeDAO = EmployeeDAO;
	}

	@Transactional
	public void addEmployee(Employee p) {
		
		logger.info("ADD In ServiceImpl");
		this.employeeDAO.addEmployee(p);
	}

	@Transactional
	public void updateEmployee(Employee p) {
		this.employeeDAO.updateEmployee(p);
	}

	@Transactional
	public List<Employee> listEmployees() {
		System.out.println("ALL-In ServiceImpl");
		return this.employeeDAO.listEmployees();
	}

	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDAO.getEmployeeById(id);
	}

	@Transactional
	public void removeEmployee(int id) {
		
		System.out.println("Service : Remove");
		this.employeeDAO.removeEmployee(id);
	}

}