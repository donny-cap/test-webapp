package com.springboot.testwebapp.service;

import com.springboot.testwebapp.model.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(long id);
	void deleteUserById(long id);

}
