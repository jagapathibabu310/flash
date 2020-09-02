package com.ibm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Employee;
import com.ibm.service.EmployeeService;

@RestController
public class EmployeeController 
{
	EmployeeService employeeService = new EmployeeService();
	
	@RequestMapping(value="/employees", method = RequestMethod.GET, 
			headers = "Accept=application/json")
	public List<Employee> getEmployees()
	{
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		return listOfEmployees;
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, 
			headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id) 
	{
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST,
			headers = "Accept=application/json")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
 
	@RequestMapping(value = "/employees", method = RequestMethod.PUT, 
			headers = "Accept=application/json")
	public Employee updateEmployee(@RequestBody Employee employee) 
	{
		return employeeService.updateEmployee(employee);
 
	}
 
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE,
			headers = "Accept=application/json")
	public void deleteEmployee(@PathVariable("id") int id)
	{
		employeeService.deleteEmployee(id);
 
	} 
 
	
}
