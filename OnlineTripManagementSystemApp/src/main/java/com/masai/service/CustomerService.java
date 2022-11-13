package com.masai.service;

import com.masai.exceptions.CustomerException;
import com.masai.model.User;

public interface CustomerService {
	
	
	public User createCustomer(User customer)throws CustomerException;
	
	public User updateCustomer(User customer,String key)throws CustomerException;

}
