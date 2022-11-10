package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.masai.exceptions.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("add-user")
	ResponseEntity<User> addUserHandler(User user) throws UserException {
		User newUser = userService.addUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@DeleteMapping("delete-user/{userId}")
	ResponseEntity<User> deleteUserHandler(@PathVariable("userId") Integer userId) throws UserException {
		User deleteUser = userService.deleteUser(userId);
		return new ResponseEntity<User>(deleteUser, HttpStatus.OK);
	}

}
