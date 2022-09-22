package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.util.DBUtil;

public class MemberDao {

	private MemberDao() {

	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private DBUtil util = DBUtil.getInstance();

	public int insert(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			conn = util.getConnection();
			String sql = "insert into Member(id, pw, name, address, phone) values(?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("member dao insert error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}

		return result;
	}

	public Member selectOne(String id, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		Member member = null;

		try {
			conn = util.getConnection();
			String sql = "select id, pw, name, address, phone from member where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("member dao selectOne error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return member;
	}

	public int delete(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			conn = util.getConnection();
			String sql = "delete from Member where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("member dao delete error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;

	}
}
