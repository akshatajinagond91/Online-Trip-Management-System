package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exceptions.AdminException;
import com.masai.model.Admin;
import com.masai.model.User;

public interface AdminDao extends JpaRepository<Admin,Integer>{
	
	public User removeUser() throws AdminException;
	
	@Query("select s from Student s where s.email= ?1 AND s.password = ?2")
	public Admin loginAdmin(String username,String password);
	

}
