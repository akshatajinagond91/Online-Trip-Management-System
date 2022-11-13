package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.BookingException;
import com.masai.model.Booking;

@Service
public interface BookingService {
	
	public Booking makeBooking(Booking booking);
	
	public Booking cancelBooking(Integer bookingId) throws BookingException; // or use userId
	
	public Booking viewBooking(Integer bookingId) throws BookingException;
	
	public List<Booking> viewAllBooking() throws BookingException;
	

}
