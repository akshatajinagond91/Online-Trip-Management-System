package com.masai.exceptions;

import java.time.LocalDateTime;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<MyErrorDetails> noHandlerException(NoHandlerFoundException nfe, WebRequest req) {

		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nfe.getMessage());
		errorDetails.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(PackageException.class)
	ResponseEntity<MyErrorDetails> packageExceptionHandler(PackageException pe, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(pe.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserException.class)
	ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ue, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ue.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.OK);
	}
	
	@ExceptionHandler(TravelsException.class)
	ResponseEntity<MyErrorDetails> travelsExceptionHandler(TravelsException pe, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(pe.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingException.class)
	ResponseEntity<MyErrorDetails> travelsExceptionHandler(BookingException be, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(be.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RouteException.class)
	ResponseEntity<MyErrorDetails> travelsExceptionHandler(RouteException re, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(re.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ReportException.class)
	ResponseEntity<MyErrorDetails> travelsExceptionHandler(ReportException re, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(re.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<MyErrorDetails> travelsExceptionHandler(MethodArgumentNotValidException me, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(me.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception pe, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(pe.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}

}
