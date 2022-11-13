package com.masai.service;

import java.util.List;

import com.masai.exceptions.FeedbackException;
import com.masai.model.Feedback;
<<<<<<< HEAD
=======


>>>>>>> 769840ab3b33b12180e2b84030ff073db068d231


public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback,String authKey) throws FeedbackException;
	
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public List<Feedback> findByCustomerId(Integer customerId,String authKey) throws FeedbackException;
	
	public List<Feedback> viewAllFeedbacks(String authKey) throws FeedbackException;
	
	

}
