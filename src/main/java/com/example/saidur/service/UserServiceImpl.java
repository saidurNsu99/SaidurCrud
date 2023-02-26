package com.example.saidur.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saidur.model.User;
import com.example.saidur.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired //inject repository dependency
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user); //save user
	}



	@Override
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) return user.get();
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>(); //create list of users variable
		userRepository.findAll().forEach(user ->users.add(user)); // keep each user in users list
		return users;
	}
	
	@Override
	public User updateUser(Long id, User user) {
		Optional<User> userById = userRepository.findById(id);
		
		if(userById.isPresent()) {
			User updatedUser = userById.get();

			updatedUser.setId(user.getId());
			updatedUser.setUsername(user.getUsername());
			updatedUser.setFirstname(user.getFirstname());
			updatedUser.setLastname(user.getLastname());
			updatedUser.setEmail(user.getEmail());
			
			return userRepository.save(updatedUser);
		}
		
		return null;
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id); //delete user by id
		return "id" + id + "is deleted successfully"; 
	}
}
