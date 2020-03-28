package com.nagp.assignmentone.userservice.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.userservice.dto.UserDTO;
import com.nagp.assignmentone.userservice.service.IUserService;

/**
 * Controller to retrieve information about the users.
 */
@RestController
public class UserServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceController.class);

	@Autowired
	private IUserService userService;
	
	/**
	 * Get user by userId
	 * @param userId
	 * @return
	 */
	 @GetMapping(value = "/user/{userId}")
	  public UserDTO getUser(@PathVariable Long userId) {
		 UserDTO userDTO = null;
		 try {
			 LOGGER.info("Getting the user of userID : {}", userId);
			 userDTO = userService.getUser(userId);
		 } catch(Exception ex) {
			 LOGGER.info("error : {}", ex);
		 }
		 
		 return userDTO;
	  }
	
}
