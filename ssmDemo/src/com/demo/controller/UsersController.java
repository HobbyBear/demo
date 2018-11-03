package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.Users;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UserService userService;

	@RequestMapping("test2")
	@ResponseBody
	public List<Users> test2() {
		return userService.findAll();
	}

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		return userService.findUsersById().getName();
	}
}
