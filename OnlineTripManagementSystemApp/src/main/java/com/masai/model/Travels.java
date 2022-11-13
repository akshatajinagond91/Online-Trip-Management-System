package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Travels {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelsId;
	private String trvelsName;
	private String agentName;
	private String address;
	private String contact;
	

}
