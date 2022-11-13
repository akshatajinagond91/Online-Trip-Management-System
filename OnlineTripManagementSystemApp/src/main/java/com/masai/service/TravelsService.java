package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.TravelsException;
import com.masai.model.Travels;

@Service
public interface TravelsService {

	public Travels addTravels(Travels travels) throws TravelsException;
	
	public Travels updateTravels(Travels travel) throws TravelsException;
	
	public Travels removeTravels(Integer travelsId) throws TravelsException;
	
	public Travels searchTravels(Integer travelsId) throws TravelsException;
	
	public List<Travels> viewTravels() throws TravelsException; 
}
