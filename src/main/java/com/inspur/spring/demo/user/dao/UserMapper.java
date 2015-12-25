package com.inspur.spring.demo.user.dao;

import java.util.List;

import com.inspur.spring.demo.user.model.User;

public interface UserMapper {

	List<User> getAll();

	List<User> getUserByName(String userName);

	User getUserById(String id);

	void updateUser(User user);

	void insertUser(User user);

	void deleteUser(String id);
}
