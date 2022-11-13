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
import com.masai.model.Booking;
import com.masai.service.BookingService;

@RestController
public class BookingController {

    @Autowired	
	private BookingService bookingService;
	
    @PostMapping("/bookingAdd")
    public ResponseEntity<Booking> makeBookingHandler(@RequestBody Booking booking) throws BookingException{
    	
        Booking bookingAdded = bookingService.makeBooking(booking);
    	
    	return new ResponseEntity<Booking>(bookingAdded,HttpStatus.CREATED); 
    }
	
    @DeleteMapping("/bookingDel/{bookingId}")
    public ResponseEntity<Booking> deleteBookingHandler(@PathVariable("bookingId") Integer bookingId) throws BookingException{
    	
    	Booking bookingRemoved = bookingService.cancelBooking(bookingId);
    	
    	return new ResponseEntity<Booking>(bookingRemoved,HttpStatus.ACCEPTED);
    }
	
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> viewBookingHandler(@PathVariable("bookingId") Integer bookingId) throws BookingException{
    	
    	Booking booking = bookingService.viewBooking(bookingId);
    	
    	return new ResponseEntity<Booking>(booking,HttpStatus.OK);
    }
	
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<List<Booking>> viewAllBookingHandler(@PathVariable("bookingId") Integer bookingId) throws BookingException{
    	
    	List<Booking> bookings = bookingService.viewAllBooking();
    	
    	return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
    }
}
