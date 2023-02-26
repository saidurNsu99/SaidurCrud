package com.example.saidur.service;

import java.util.List;

import com.example.saidur.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUserById(Long id);
	User saveUser(User student);
	String deleteUser(Long id);
	User updateUser(Long id, User student);
	

}
