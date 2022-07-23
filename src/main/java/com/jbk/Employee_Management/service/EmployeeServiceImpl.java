package com.jbk.Employee_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Employee_Management.dao.EmployeeDao;
import com.jbk.Employee_Management.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Override
	public boolean addEmployee(Employee employee) {
		boolean value = dao.addEmployee(employee);
		return value;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = dao.getAllEmployee();
		return employees;
	}

	@Override
	public Employee getParticularEmployee(int id) {
		Employee employee = dao.getParticularEmployee(id);
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean value = dao.updateEmployee(employee);
		return value;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean value = dao.deleteEmployee(id);
		return value;
	}

}
