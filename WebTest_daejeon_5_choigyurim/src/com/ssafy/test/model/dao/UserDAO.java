package com.ssafy.test.model.dao;

import com.ssafy.test.dto.UserDto;

public interface UserDAO {
	//로그인
	public UserDto selectOne(String id, String pw);
	
}
