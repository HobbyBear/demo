package com.demo.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.pojo.Users;

public interface UsersMapper {

	public List<Users> findAll();

	public Users findById(Integer id);

	public int save(Users users);

	public Users findByNameAndDate(@Param("name") String name, @Param("date") Date date);
}
