package com.springboot.testwebapp.service;

import com.springboot.testwebapp.exception.InvalidAgeException;
import com.springboot.testwebapp.model.User;
import com.springboot.testwebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		if (!user.isAdult()) {
			throw new InvalidAgeException("User must be at least 18 years old.");
		}
		this.userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" User not found for id :: " + id);
		}
		return user;
	}

	@Override
	public void deleteUserById(long id) {
		this.userRepository.deleteById(id);
	}


}
