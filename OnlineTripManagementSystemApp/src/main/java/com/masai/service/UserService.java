package com.masai.service;

import com.masai.exceptions.UserException;
import com.masai.model.User;

public interface UserService {
	
	public User addUser(User user) throws UserException;
	
	public User updateUser(User user,String key)throws UserException;
	
	public User deleteUser(Integer userId) throws UserException;

}
