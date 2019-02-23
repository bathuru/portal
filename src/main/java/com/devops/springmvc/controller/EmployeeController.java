package com.devops.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devops.springmvc.domain.Employee;
import com.devops.springmvc.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired(required = false)
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		
		logger.info("Controller : getAllEmployees");
		List<Employee> list = employeeService.getAllEmployees();
					
		model.addAttribute("listEmployees", list);
		return "displayAllEmployee";
	}
	
    @RequestMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") int id, Model model){
    	
    	logger.info("Controller : Edit");
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        return "updateEmployee";
    }
    
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("Employee") Employee p){

		logger.info("Controller : Add");
		this.employeeService.addEmployee(p);
		return "redirect:/employees";
	}

	@RequestMapping(value= "/employee/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("Employee") Employee p){

		logger.info("Controller : Update");
		this.employeeService.updateEmployee(p);
		return "redirect:/employees";
	}
	
	@RequestMapping("/employee/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		
		logger.info("Controller : Remove");
		System.out.println("Controller : Remove");
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

	@RequestMapping(value = "/add")
	public String testEmployees(Model model) {
		
		return "addEmployee";
	}
}