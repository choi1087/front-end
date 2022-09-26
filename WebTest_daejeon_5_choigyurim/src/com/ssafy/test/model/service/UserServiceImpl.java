package com.ssafy.test.model.service;

import com.ssafy.test.dto.UserDto;
import com.ssafy.test.model.dao.UserDAOImpl;

public class UserServiceImpl implements UserService{
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	public static UserServiceImpl getService() {
		return userServiceImpl;
	}
	
	private static UserDAOImpl userDao;
	public UserServiceImpl() {
		userDao = UserDAOImpl.getUserDAO();
	}

	@Override
	public UserDto login(String id, String pw) {		
		return userDao.selectOne(id, pw);
	}
	
}
