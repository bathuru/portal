package com.spider.springmvc.dao;

import java.util.List;

import com.spider.springmvc.domain.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}