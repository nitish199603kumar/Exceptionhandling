package com.nitish.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nitish.dto.UserRequest;
import com.nitish.entity.User;
import com.nitish.exception.NoUserFoundException;
import com.nitish.exception.UserNotFoundException;
import com.nitish.repository.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepository;

		
		public User saveUser(UserRequest userRequest)
		{
		
	//1st way to UserRequest object into User Class We can set into User Class like
//			@AllArgsConstructor(staticName="build").So All field will be access
	User build = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
			userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		
//2nd way ......
//			User user=new User();
//			user.setName(userRequest.getName());
			return userRepository.save(build);
		}
		
		
		public List<User> getAllUsers() throws NoUserFoundException
		{
			List<User> findAll = userRepository.findAll();
	//		LocalDateTime dt=LocalDateTime.now();
	//		System.out.println("Find All User" +findAll);
	//		System.out.println("Find All User" +dt.now());
				
			if(findAll.size()!=0)
			{
				return findAll;
			}else {
				throw new NoUserFoundException("No User Data Found");
			}
			
		//	return userRepository.findAll();
			
		}
		
		public User getUser(Integer id) throws UserNotFoundException
		{
			 User findByUserId = userRepository.findByUserId(id);
			 
			 if(findByUserId!=null)
			 {
				 return findByUserId;
			 }else {
				 
				 throw new UserNotFoundException("User is not found with this Id " +id);
			 }
		}
		
		
		
}
