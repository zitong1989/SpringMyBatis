package com.inspur.spring.demo.user.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.inspur.spring.demo.user.model.User;
import com.inspur.spring.util.DateTimeUtil;
import com.inspur.spring.util.IdWorker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml", "classpath*:mybatis-config.xml" })
public class UserMapperTest {

	private User user;

	@Autowired
	private UserMapper userMapper;

	@Before
	public void init() {
		user = new User();
		user.setId(IdWorker.uuid());
		user.setUserName("test");
		user.setPassword("123456");
		user.setGender("M");
		user.setEmail("test@inspur.com");
		user.setCtime(DateTimeUtil.getCurrentTime());
	}

	@Test
	public void test() {
		userMapper.insertUser(user);
		List<User> users = userMapper.getAll();
		Assert.isTrue(users.size() == 1);

		List<User> otherUsers = userMapper.getUserByName("test");
		Assert.isTrue(otherUsers.size() == 1);
		otherUsers = userMapper.getUserByName("test01");
		Assert.isTrue(otherUsers.size() == 0);

		User otherUser = userMapper.getUserById(user.getId());
		Assert.isTrue(otherUser.getUserName().equals(user.getUserName()));

		user.setEmail("test01@inspur.com");
		userMapper.updateUser(user);
		otherUser = userMapper.getUserById(user.getId());
		Assert.isTrue(otherUser.getEmail().equals(user.getEmail()));

		userMapper.deleteUser(user.getId());
		users = userMapper.getAll();
		Assert.isTrue(users.size() == 0);
	}

}
