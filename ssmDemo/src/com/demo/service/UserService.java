package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UsersMapper;
import com.demo.pojo.Users;
import com.github.pagehelper.PageHelper;

@Service
public class UserService {

	@Autowired
	private UsersMapper usersMapper;

	public Users findUsersById() {
		return usersMapper.findById(2);
	}

	public List<Users> findAll() {
		PageHelper.startPage(1, 1);
		return usersMapper.findAll();
	}
}
