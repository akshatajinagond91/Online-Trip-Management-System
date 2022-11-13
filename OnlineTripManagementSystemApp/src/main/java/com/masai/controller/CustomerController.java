package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.model.User;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<User> saveCustomer(@RequestBody User customer) throws CustomerException {
		
		User savedCustomer= cService.createCustomer(customer);
		
		
		return new ResponseEntity<User>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<User> updateCustomer(@RequestBody User customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		User updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<User>(updatedCustomer,HttpStatus.OK);
		
	}
	

	
	
	
	
	
	
	
	
	
}
