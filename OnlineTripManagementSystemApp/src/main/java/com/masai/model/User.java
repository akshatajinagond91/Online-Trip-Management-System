package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer userId;
	private String name;
	private String mobileNo;
	private String password;
	private String email;
	private String userType;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Feedback> feedbacks = new ArrayList<>();
	
}
