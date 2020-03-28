package com.nagp.assignmentone.userservice.service;

import com.nagp.assignmentone.userservice.dto.UserDTO;
import com.nagp.assignmentone.userservice.model.User;


public interface IUserService {

	/**
	 * Get the user by using userId
	 * @param userId
	 * @return
	 */
	public UserDTO getUser(final Long userId);

	
}
