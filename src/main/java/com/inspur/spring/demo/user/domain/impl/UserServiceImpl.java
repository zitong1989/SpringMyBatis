package com.inspur.spring.demo.user.domain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.spring.demo.user.dao.UserMapper;
import com.inspur.spring.demo.user.domain.UserService;
import com.inspur.spring.demo.user.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public List<User> getUserByName(String userName) {
		String tempUserName = "%" + userName + "%";
		return userMapper.getUserByName(tempUserName);
	}

	@Override
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public void deleteUser(String id) {
		userMapper.deleteUser(id);
	}

}
