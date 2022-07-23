package com.jbk.Employee_Management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Employee_Management.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory factory;
	
	
	@Override
	public boolean addEmployee(Employee employee) {
		Session session = null;
		boolean value = false;
		
		try {
			session = factory.openSession();
			Employee emp = session.get(Employee.class, employee.getId());
			
			if(emp==null) {
				Transaction transaction = session.beginTransaction();
				session.save(employee);
				transaction.commit();
				value=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return value;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		Session session = null;
		List<Employee> employees = new ArrayList<>();
		
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			employees = criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return employees;
	}

	@Override
	public Employee getParticularEmployee(int id) {
		
		Session session = null;
		Employee employee = null;
		
		try {
			session = factory.openSession();
			employee = session.get(Employee.class, id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
			value=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public boolean deleteEmployee(int id) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = factory.openSession();
			Employee employee = session.get(Employee.class, id);
			
			if(employee!=null) {
				Transaction transaction = session.beginTransaction();
				session.delete(employee);
				transaction.commit();
				value = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

}
