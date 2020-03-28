package com.nagp.assignmentone.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagp.assignmentone.userservice.dto.UserDTO;
import com.nagp.assignmentone.userservice.model.User;
import com.nagp.assignmentone.userservice.service.IUserService;

@Component
public class UserService implements IUserService{

	private static final String USER_NOT_FOUND ="User not found";
	
	private static final String USER_NOT_FOUND_DESC ="User not found of userId :";
	
	static List<User> users= null;
	static {
		users = new ArrayList<>();
		users.add(new User(1,"John",23,"john.doe@google.com"));
		users.add(new User(2,"Ashish",25,"ashish.aggarwal@gmail.com"));
	}
	
	@Override
	public UserDTO getUser(Long userId) {
		Optional<User> user = users.stream().filter(p -> p.getUserId() == userId).distinct().findFirst();
		UserDTO userDTO = new UserDTO();
		if(user.isPresent()) {
			User currentUser = user.get();
			userDTO.setName(currentUser.getName());
			userDTO.setAge(currentUser.getAge());
			userDTO.setEmail(currentUser.getEmail());
		} else {
			userDTO.setError(USER_NOT_FOUND);
			userDTO.setErrorDescription(USER_NOT_FOUND_DESC + userId);
		}
		return userDTO;
	}

}
