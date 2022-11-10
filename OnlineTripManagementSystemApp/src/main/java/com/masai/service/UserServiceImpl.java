package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.UserException;
import com.masai.model.User;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	@Override
	public User addUser(User user) throws UserException {
		
		Optional<User> optional = userDao.findById(user.getUserId());
	
		if(optional.isPresent()) {
			throw new UserException("User Already Exist with UserId : "+user.getUserId());
		}else {
			userDao.save(user);
			return user;
		}
		
	}

	@Override
	public User deleteUser(Integer userId) throws UserException {

		Optional<User> optional = userDao.findById(userId);
		
		if(optional.isPresent()) {
			User user = optional.get();
			userDao.delete(user);
			return user;
		}else {
			throw new UserException("User Doesn't Exist with UserId : "+userId);
		}
		
	}

	
	
}
