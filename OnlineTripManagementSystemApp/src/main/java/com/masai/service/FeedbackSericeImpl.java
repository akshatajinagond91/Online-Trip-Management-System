package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.FeedbackException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Feedback;
import com.masai.model.User;
import com.masai.repository.FeedbackDao;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;



@Service
public class FeedbackSericeImpl implements FeedbackService{

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	 private SessionDao sessionRepository;
	
	@Autowired
	private UserDao userRepository;

	@Override
	public Feedback addFeedback(Feedback feedback, String authKey) throws FeedbackException {
		
		CurrentUserSession currentUserLoginSession=sessionRepository.findByUuid(authKey);
		
		User user=userRepository.findById(currentUserLoginSession.getUserId()).get();
		
		if(user.getUserType().equals("admin"))
		{
			throw new FeedbackException("Only users can give feedback");
		}
		
		
//		feedback.setUser(user);
		
		return feedbackDao.save(feedback);
		
		
	}

	@Override
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException {
		
		Optional<Feedback> optFeedback= feedbackDao.findById(feedbackId);
		
		if(!optFeedback.isPresent())
		{
			throw new FeedbackException("No Feedback present with the given Feedback Id");
		}
		
		return optFeedback.get();
		
		
	}

	@Override
	public List<Feedback> findByCustomerId(Integer customerId,String authKey) throws FeedbackException {
		
        CurrentUserSession currentUserLoginSession=sessionRepository.findByUuid(authKey);
		
		
		User user=userRepository.findById(currentUserLoginSession.getUserId()).get();
		
		if(user.getUserType().equals("User"))
		{
			throw new FeedbackException("Only admins can access this feature");
		}
		
		Optional<User> userOptional=userRepository.findById(customerId);
		
		if(!userOptional.isPresent())
		{
			throw new FeedbackException("No user present with the given customer Id");
		}
		
		User userRequired=userOptional.get();
		
		List<Feedback> list=userRequired.getFeedbacks();
		if(list.size()==0)
		{
			throw new FeedbackException("No feedbacks made by the customer");
		}
		
		return list;
		
	}

	@Override
	public List<Feedback> viewAllFeedbacks(String authKey) throws FeedbackException {
		
		    CurrentUserSession currentUserLoginSession=sessionRepository.findByUuid(authKey);
			
			
			User user=userRepository.findById(currentUserLoginSession.getUserId()).get();
			
			if(user.getUserType().equals("User"))
			{
				throw new FeedbackException("Only admins can access this feature");
			}
			
			List<Feedback> ansList=feedbackDao.getAllFeedbacks();
			
			return ansList;
			
			
			
	}

	

}
