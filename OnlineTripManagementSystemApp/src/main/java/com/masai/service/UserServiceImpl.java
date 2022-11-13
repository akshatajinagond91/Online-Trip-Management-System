package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;
import com.masai.exceptions.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	@Override
	public User addUser(User user)throws UserException {
		
		
		Optional<User> opt = userDao.findById(user.getUserId());
		
		
		if(opt.isEmpty()) { 
			throw new UserException("Customer Already Registered with Mobile number");
		}
		else {
			userDao.save(user);
		    return user;
		}
			
    }

	@Override
	public User updateUser(User user, String key) throws UserException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to update a customer");
		}
		
	
		
		if(user.getUserId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return userDao.save(user);
		}
		else
			throw new UserException("Invalid Customer Details, please login first");
	
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


