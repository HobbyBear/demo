package com.oracle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.SearchVO;

public interface UserMapper {
	public Users findById(Integer userId);
	public List<Users> findByCondition(SearchVO vo);
	public Users login(String username,String userpass);
	public Users login2(@Param("username")String username,@Param("userpass")String userpass);
}
