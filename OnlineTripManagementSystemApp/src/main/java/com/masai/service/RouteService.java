package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.RouteException;
import com.masai.model.Route;

@Service
public interface RouteService{
	
	public Route addRoute(Route route);
	
	public Route updateRoute(Route route) throws RouteException;

	public Route removeRoute(Integer routeId) throws RouteException ;
	
	public Route searchRoute(Integer routeId) throws RouteException ;
	
	public List<Route> viewRouteList() throws RouteException ;
	
}
