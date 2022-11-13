package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;
import com.masai.model.User;
import com.masai.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	public ResponseEntity<List<User>> getAllUserHandler() throws AdminException{
		
		List<User> users = null;
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	

}
