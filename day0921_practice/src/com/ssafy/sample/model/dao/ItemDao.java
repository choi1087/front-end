package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Item;
import com.ssafy.sample.util.DBUtil;

public class ItemDao {
	private ItemDao() {

	}

	private static ItemDao instacne = new ItemDao();

	public static ItemDao getInstance() {
		return instacne;
	}

	private DBUtil util = DBUtil.getInstance();

	public int insert(String name, int price) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			conn = util.getConnection();
			String sql = "insert into item (name, price) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("item dao insert error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public Item selectOne(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Item result = null;

		try {
			conn = util.getConnection();
			String sql = "select no, name, price, clicked from item where no=? order by no desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println("item dao selectOne error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<Item> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Item> items = new ArrayList<>();

		try {
			conn = util.getConnection();
			String sql = "select no, name, price, clicked from item order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				items.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			System.out.println("item dao selectAll error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return items;
	}

	public int delete(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			conn = util.getConnection();
			String sql = "delete from item where no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("item dao delete error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public void updateClicked(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			String sql = "update item set clicked = clicked + 1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("item dao update clicked error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(rs, pstmt, conn);
		}
	}
}
