package com.devops.springmvc.dao;

import java.util.List;

import com.devops.springmvc.domain.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}