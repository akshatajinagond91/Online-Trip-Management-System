package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.RouteException;
import com.masai.model.Route;
import com.masai.repository.RouteDao;

@Service
public class RouteServiceImpl implements RouteService{
	
	@Autowired
	private RouteDao routeDao;

	@Override
	public Route addRoute(Route route) {

	   Route savedRoute = routeDao.save(route);
		
	   return savedRoute;	
	}

	@Override
	public Route updateRoute(Route route) throws RouteException {
		
		Optional<Route> opt = routeDao.findById(route.getRouteId());
		
		if(opt.isEmpty()){
			throw new RouteException("Route Id is invalid");
		}
		else {
			Route updatedRoute = routeDao.save(route);
			return updatedRoute;
		}
		
	}

	@Override
	public Route removeRoute(Integer routeId) throws RouteException {
		
		Optional<Route> opt = routeDao.findById(routeId);
		
		if(opt.isPresent()) {
			routeDao.deleteById(routeId);
			return opt.get();
		}
		else
			throw new RouteException("Route Id is invalid");
		
	}

	@Override
	public Route searchRoute(Integer routeId) throws RouteException {
		
	  return routeDao.findById(routeId).orElseThrow(() -> new RouteException("Route Id is invalid"));
		
	}

	@Override
	public List<Route> viewRouteList() throws RouteException{
		
	   List<Route> routeList = routeDao.findAll();
		
	   if(routeList.size()==0)
		   throw new RouteException("No route data present");
	   else
		   return routeList;
	}
	

}
