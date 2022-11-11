package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exceptions.AdminException;
import com.masai.model.Admin;
import com.masai.model.User;

public interface AdminDao extends JpaRepository<Admin,Integer>{
	
	public User removeUser() throws AdminException;

}
