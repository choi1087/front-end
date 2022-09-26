package com.ssafy.test.model.service;

import com.ssafy.test.dto.UserDto;

public interface UserService {
	//로그인
	public UserDto login(String id, String pw);
}
