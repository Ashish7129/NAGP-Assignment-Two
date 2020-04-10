package com.nagp.assignmentone.userservice.service;

import org.springframework.data.repository.CrudRepository;

import com.nagp.assignmentone.userservice.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
