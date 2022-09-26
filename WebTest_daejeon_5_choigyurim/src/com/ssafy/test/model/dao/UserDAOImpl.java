package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.test.dto.UserDto;
import com.ssafy.test.util.DBUtil;

public class UserDAOImpl implements UserDAO {
	private static UserDAOImpl userDAOImpl = new UserDAOImpl();

	public static UserDAOImpl getUserDAO() {
		return userDAOImpl;
	}

	private DBUtil dbUtil;

	public UserDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}

	@Override
	public UserDto selectOne(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto userDto = null;

		try {
			conn = dbUtil.getConnection();
			String sql = "select id, pw from user where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDto = new UserDto(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println("user insert error");
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return userDto;
	}

}
