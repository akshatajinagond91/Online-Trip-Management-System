package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exceptions.TravelsException;

import com.masai.model.Travels;

import com.masai.repository.TravelsDao;

public class TravelsServiceImpl implements TravelsService {

	@Autowired
	public TravelsDao travelsdao;

	@Override
	public Travels addTravels(Travels travels) throws TravelsException {
		Optional<Travels> optional = travelsdao.findById(travels.getTravelsId());

		if (optional.isPresent()) {
			throw new TravelsException("travel Already Exist with travelId : " + travels.getTravelsId());
		} else {
			travelsdao.save(travels);
			return travels;
		}

	}

	@Override
	public Travels updateTravels(Travels travel) throws TravelsException {
		
		Optional<Travels> optional = travelsdao.findById(travel.getTravelsId());
		
		if(optional.isPresent()) {
			travelsdao.save(travel);
			return travel;
		}else {
			throw new TravelsException("TravelId does not exist");
		}
		
	}

	@Override
	public Travels removeTravels(Integer travelsId) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<Travels> optional = travelsdao.findById(travelsId);

		if (optional.isPresent()) {
			Travels travels = optional.get();
			travelsdao.delete(travels);
			return travels;
		} else {
			throw new TravelsException("travels Doesn't Exist with UserId : " + travelsId);
		}
	}

	@Override
	public Travels searchTravels(Integer travelsId) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<Travels> optional = travelsdao.findById(travelsId);
		if (optional.isPresent()) {
			Travels travels = optional.get();
			return travels;
		} else {
			throw new TravelsException("Travels does not exists with travelsId" + travelsId);
		}
	}

	@Override
	public List<Travels> viewTravels() throws TravelsException {
		// TODO Auto-generated method stub
		List<Travels> travels = travelsdao.findAll();
		if (travels.isEmpty())
			throw new TravelsException("No travel is present in database");
		return travels;
	}

}
