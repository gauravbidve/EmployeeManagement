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
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Employee_Management.entity.Country;
import com.jbk.Employee_Management.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	CountryService service;
	
	@PostMapping("/addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country country){
		
		boolean value = service.addCountry(country);
		
		if(value) {
			return new ResponseEntity<String> ("Country Added Successfully...!!!",HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String> ("Something went wrong...!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping("/getAllCountry")
	public ResponseEntity getAllCountry(){
		
		List<Country> countries = service.getAllCountry();
		
		if(!countries.isEmpty()) {
			return new ResponseEntity<List<Country>>(countries,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Records Found in Database...!!!",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getParticularCountry")
	public ResponseEntity getParticularCountry(int cid){
		
		Country country = service.getParticularCountry(cid);
		
		if(country!=null) {
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Records Found...!!!",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/updateCountry")
	public ResponseEntity<String> updateCountry(@RequestBody Country country){
		
		boolean value = service.updateCountry(country);
		
		if(value) {
			return new ResponseEntity<String>("Record Updated Successfully...",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Country Name Already Exists...!!!",HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	@DeleteMapping("/deleteCountry")
	public ResponseEntity<String> deleteCountry(int cid){
		
		boolean value = service.deleteCountry(cid);
		
		if(value) {
			return new ResponseEntity<String>("Record deleted successfully...!!!",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Record doesn't exist with given id...",HttpStatus.NOT_FOUND);
		}
		
	}
	
}
