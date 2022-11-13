package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.RouteException;
import com.masai.model.Booking;
import com.masai.model.Route;
import com.masai.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;

	@PostMapping("/routeAdd")
    public ResponseEntity<Route> addRouteHandler(@RequestBody Route route) throws RouteException{
    	
        Route routeAdded = routeService.addRoute(route);
    	
    	return new ResponseEntity<Route>(routeAdded,HttpStatus.CREATED); 
    }
	
	@PostMapping("/routeUpdate")
    public ResponseEntity<Route> updateRouteHandler(@RequestBody Route route) throws RouteException{
    	
        Route routeUpdated = routeService.addRoute(route);
    	
    	return new ResponseEntity<Route>(routeUpdated,HttpStatus.ACCEPTED); 
    }
	
	@DeleteMapping("/routeDel/{routeId}")
    public ResponseEntity<Route> removeRouteHandler(@PathVariable("routeId") Integer routeId) throws RouteException{
    	
        Route removedRoute = routeService.removeRoute(routeId);
    	
    	return new ResponseEntity<Route>(removedRoute,HttpStatus.OK); 
    }
	
	@GetMapping("/route/{routeId}")
    public ResponseEntity<Route> searchRouteHandler(@PathVariable("routeId") Integer routeId) throws RouteException{
    	
        Route route = routeService.searchRoute(routeId);
    	
    	return new ResponseEntity<Route>(route,HttpStatus.OK); 
    }
	
	@GetMapping("/routes")
    public ResponseEntity<List<Route>> viewRouteListHandler() throws RouteException{
    	
        List<Route> routeList = routeService.viewRouteList();
    	
    	return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK); 
    }
	
	
}
