package com.jbk.Employee_Management.service;

import java.util.List;

import com.jbk.Employee_Management.entity.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getParticularEmployee(int id);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int id);
	
}
