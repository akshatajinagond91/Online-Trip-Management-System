package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.TravelsException;
import com.masai.model.Travels;
import com.masai.service.TravelsService;

@RestController
public class TravelController {

	@Autowired
	TravelsService travelsService;
	
	@PostMapping("/add-travels")
	ResponseEntity<Travels> addTravelHandler(@RequestBody Travels travels) throws TravelsException{
	Travels travels2 = travelsService.addTravels(travels);
	return new ResponseEntity<Travels>(travels2,HttpStatus.CREATED);
	}
	
	@PutMapping("/update-travels")
	ResponseEntity<Travels> updateTravelHandler(@RequestBody Travels travels) throws TravelsException{
	Travels travels2 = travelsService.updateTravels(travels);
	return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-travels/{travelsId}")
	ResponseEntity<Travels> deleteTravelHandler(@PathVariable("travelsId") Integer travelsId) throws TravelsException{
	Travels travels2 = travelsService.removeTravels(travelsId);
	return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
	
	@GetMapping("/search-travles/{travelsId}")
	ResponseEntity<Travels> searchTravelHandler(@PathVariable("travelsId") Integer travelsId) throws TravelsException{
	Travels travels2 = travelsService.searchTravels(travelsId);
	return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
	
	@GetMapping("/search-travels")
	ResponseEntity<List<Travels>> searchTravelHandler() throws TravelsException{
	List<Travels> travels2 = travelsService.viewTravels();
	return new ResponseEntity<List<Travels>>(travels2,HttpStatus.OK);
	}
	
}
