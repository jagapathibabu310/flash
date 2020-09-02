package com.ibm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibm.bean.Employee;

public class EmployeeService 
{
	static HashMap<Integer,Employee> employeeIdMap = getEmployeeIdMap();
	
	public EmployeeService()
	{
		super();
		
		if(employeeIdMap==null)
		{
			employeeIdMap = new HashMap<Integer, Employee>();
			
			employeeIdMap.put(1, new Employee(1, "Ammi", 23, 40000, "Blr"));
			employeeIdMap.put(2, new Employee(2, "Radha", 24, 50000, "Blr"));
			employeeIdMap.put(3, new Employee(3, "Mahi", 25, 30000, "Blr"));
			employeeIdMap.put(4, new Employee(4, "Chandi", 26, 60000, "Blr"));
			employeeIdMap.put(5, new Employee(5, "Priya", 28, 40000, "Blr"));
			
		}
		
		
	}
	
	public List<Employee> getAllEmployees()
	{
		
		List<Employee> employees = new ArrayList<Employee>(employeeIdMap.values());
		return employees;
	}
	
	public Employee getEmployee(int id)
	{
		
		Employee employee = employeeIdMap.get(id);
		return employee;
	}

	public Employee addEmployee(Employee employee)
	{
		employee.setId(getMaxId()+1);
		employeeIdMap.put(employee.getId(), employee);
		return employee;
	}

	public Employee updateEmployee(Employee employee) 
	{
		if(employee.getId()<=0)
		{
			return null;
		}
		else
		{
			employeeIdMap.put(employee.getId(), employee);
			return employee;
		}
	}

	public void deleteEmployee(int id) 
	{
		employeeIdMap.remove(id);
		
	}
	
	public static HashMap<Integer, Employee> getEmployeeIdMap()
	{
		return employeeIdMap;
	}
 
	
	public static int getMaxId()
	{ 
		int max=0;
		for (int id:employeeIdMap.keySet())
		{ 
			if(max<=id)
			max=id;
 
		} 
		return max;
	}
}
