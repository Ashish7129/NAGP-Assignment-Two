package com.nagp.assignmentone.userservice.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.userservice.dto.UserDTO;
import com.nagp.assignmentone.userservice.service.IUserService;

/**
 * Controller to retrieve information about the users.
 */
@RestController
public class UserServiceController {

	@Autowired
	private IUserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * @param userId
	 * @return
	 */
	 @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	  public UserDTO getUser(@PathVariable Long userId) {
		 UserDTO userDTO = null;
		 try {
			 logger.info("Getting the user of userID :" + userId);
			 userDTO = userService.getUser(userId);
		 } catch(Exception ex) {
			 logger.info("error");
			 ex.printStackTrace();
		 }
		 
		 return userDTO;
	  }
	
}
