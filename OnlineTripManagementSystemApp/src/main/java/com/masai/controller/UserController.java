package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/userAdd")
	public ResponseEntity<User> addUserHandler(@RequestBody User user) throws UserException {
		
		User savedUser= userService.addUser(user);
		
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/userUpdate")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user,@RequestParam String key ) throws UserException {
		
		User updatedUser= userService.updateUser(user, key);
				
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}
	
//	@DeleteMapping("/userDel/{}")
//	public ResponseEntity<User> deleteUserHandler(@RequestBody User user,@RequestParam String key ) throws UserException {
//		
//		User updatedUser= userService.updateUser(user, key);
//				
//		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
//		
//	}
	

	
	
	
	
	
	
	
	
	
}
