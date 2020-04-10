package com.nagp.assignmentone.userservice.controllers;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.userservice.dto.UserDTO;
import com.nagp.assignmentone.userservice.dto.UserRequestDTO;
import com.nagp.assignmentone.userservice.model.User;
import com.nagp.assignmentone.userservice.service.UserRepository;

/**
 * Controller to retrieve information about the users.
 */
@RestController
public class UserServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	private static final String USER_NOT_FOUND ="User not found";
	
	private static final String USER_NOT_FOUND_DESC ="User not found of userId : ";
	/**
	 * Add the user into the database
	 * @param userRequest
	 * @return
	 */
	@PostMapping(path="/add")
	  public @ResponseBody String addNewUser (@RequestBody UserRequestDTO userRequest) {
	   
	    User user = new User();
	    user.setName(userRequest.getName());
	    user.setAge(userRequest.getAge());
	    user.setEmail(userRequest.getEmail());
	    userRepository.save(user);
	    return "Saved";
	  }
	
	/**
	 * Get user by userId
	 * @param userId
	 * @return
	 */
	 @GetMapping(value = "/user/{userId}")
	  public UserDTO getUser(@PathVariable Integer userId) {
		 Optional<User> user = null;
		 UserDTO userDTO =new UserDTO();
		 try {
			 LOGGER.info("Getting the user of userID : {}", userId);
			 user = userRepository.findById(userId);
			 if(user.isPresent()) {
				 User currUser = user.get();
				 userDTO.setName(currUser.getName());
				 userDTO.setAge(currUser.getAge());
				 userDTO.setEmail(currUser.getEmail());
			 } else {
				 userDTO.setError(USER_NOT_FOUND);
				 userDTO.setErrorDescription(USER_NOT_FOUND_DESC + userId);
			 }
			 
		 } catch(Exception ex) {
			 LOGGER.info("error : {}", ex);
		 }
		 
		 return userDTO;
	  }
	
}
