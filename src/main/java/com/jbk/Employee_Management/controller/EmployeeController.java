package com.jbk.Employee_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Employee_Management.entity.Employee;
import com.jbk.Employee_Management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		
		boolean value = service.addEmployee(employee);
		
		if(value) {
			return new ResponseEntity<String>("Employee Added Successfully...!!!",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Something went wrong...!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity getAllEmployee(){
		
		List<Employee>employees = service.getAllEmployee();
		
		if(!employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Record is Empty...!!!",HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/getParticularEmployee")
	public ResponseEntity getParticularEmployee(@RequestParam int id){
		
		Employee employee = service.getParticularEmployee(id);
		
		if(employee!=null) {
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Record not found with the given Id...",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		
		boolean value = service.updateEmployee(employee);
		
		if(value){
			return new ResponseEntity<String>("Record Updated Succefully...!!!",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Something went wrong...!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestParam int id){
		
		boolean value = service.deleteEmployee(id);
		
		if(value) {
			return new ResponseEntity<String>("Record Deleted Successfully...!!!",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Record not found with the given Id...!!!",HttpStatus.NOT_FOUND);
		}
		
	}
	
}
