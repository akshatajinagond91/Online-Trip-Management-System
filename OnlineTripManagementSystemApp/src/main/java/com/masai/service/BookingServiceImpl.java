package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BookingException;
import com.masai.model.Booking;
import com.masai.repository.BookingDao;
@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public Booking makeBooking(Booking booking) {
		
		Booking bookingAdded = bookingDao.save(booking);
		
		return bookingAdded;
		
	}

	@Override
	public Booking cancelBooking(Integer bookingId) throws BookingException {
		
		//remove booking row
		Optional<Booking> opt = bookingDao.findById(bookingId);
		
		Booking booking = opt.get();
		
		if(opt.isPresent()) {
			bookingDao.deleteById(bookingId);;
			return booking;
		}
		else
			throw new BookingException("Booking Id doesn't match any record");
		
	}

	@Override
	public Booking viewBooking(Integer bookingId) throws BookingException {
		
	   return bookingDao.findById(bookingId).orElseThrow(() -> new BookingException("Booking Id doesn't match any record"));
		
	}

	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		
	   List<Booking> bookings = bookingDao.findAll();
		
	   if(bookings.size()==0)
		   throw new BookingException("No bookings available");
	   else
		   return bookings;
	}

}
