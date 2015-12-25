package com.inspur.spring.demo.user.domain;

import java.util.List;

import com.inspur.spring.demo.user.model.User;

public interface UserService {
	
	List<User> getAll();

	List<User> getUserByName(String userName);

	User getUserById(String id);

	void updateUser(User user);

	void insertUser(User user);

	void deleteUser(String id);
}
