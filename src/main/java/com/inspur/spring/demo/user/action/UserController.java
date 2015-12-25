package com.inspur.spring.demo.user.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.spring.demo.user.domain.UserService;
import com.inspur.spring.demo.user.model.User;
import com.inspur.spring.util.JSONUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	@ResponseBody
	public String getUsers() {
		List<User> users = userService.getAll();
		return JSONUtil.Object2JSON(users);
	}

	@RequestMapping(value = "/query", method = { RequestMethod.GET })
	@ResponseBody
	public String getUserByName(@RequestParam(value = "name", required = false) String name) {
		List<User> users = userService.getUserByName(name);
		return JSONUtil.Object2JSON(users);
	}

	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	@ResponseBody
	public String getUserById(@PathVariable("id") String id) {
		return JSONUtil.Object2JSON(userService.getUserById(id));
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
		return "success";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "success";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String insertUser(@RequestBody User user) {
		userService.insertUser(user);
		return "success";
	}
}
