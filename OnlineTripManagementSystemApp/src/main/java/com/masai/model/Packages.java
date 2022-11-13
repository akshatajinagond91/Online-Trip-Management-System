package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Packages {
	
	@OneToOne
	private Hotel hotel;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
	
    @OneToOne(cascade = CascadeType.ALL)
	private Hotel bookedHotel;
    
    @OneToMany(cascade = CascadeType.ALL)
	private List<Hotel> hotels = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
	private Route route;
	
	
}
