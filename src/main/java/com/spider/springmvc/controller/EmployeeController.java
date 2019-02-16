package com.spider.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spider.springmvc.domain.Employee;
import com.spider.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired(required = false)
	private EmployeeService employeeService;
	
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService ps){
		this.employeeService = ps;
	}

	@RequestMapping(value = "/add")
	public String testEmployees(Model model) {
		
		System.out.println("In Test !!!");
		return "add";
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		
		System.out.println("Controller : All Employees");
		model.addAttribute("listEmployees", employeeService.listEmployees());
		return "Employee";
	}
	
	@RequestMapping(value= "/Employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("Employee") Employee p){

		System.out.println("Controller : Add");
		this.employeeService.addEmployee(p);
		return "redirect:/employees";
	}

	@RequestMapping(value= "/Employee/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("Employee") Employee p){

		System.out.println("Controller : Update");
		this.employeeService.updateEmployee(p);
		return "redirect:/employees";
	}
	
	@RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		
		System.out.println("Controller : Remove");
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        return "update";
    }
	
}