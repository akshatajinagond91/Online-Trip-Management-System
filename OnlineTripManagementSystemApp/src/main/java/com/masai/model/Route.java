package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;
    private String routeFrom;
    private String routeTo;
    private Double fare;
    
    @OneToOne(cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
	private Bus bus;
	
}
