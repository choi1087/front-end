package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	int insert(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "insert into book_tb(title, writer, price, publisher)\r\n" + "values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getPublisher());

			result = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("insert error");
			ex.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return result;
	}

	int delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "delete from book_tb where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			pstmt.executeUpdate();
			result = 1;
		} catch (Exception ex) {
			System.out.println("updateReadCount error");
			ex.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return result;
	}

	Book selectOne(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Book result = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select bno, title, writer, price, publisher\r\n" + "from book_tb where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Book b = new Book();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setPublisher(rs.getString(5));
				result = b;
			}

		} catch (Exception ex) {
			System.out.println("selectOne error");
			ex.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return result;
	}

	List<Book> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Book> result = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select bno, title, writer, price, publisher\r\n" + "from book_tb order by bno";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setPublisher(rs.getString(5));
				result.add(b);
			}
		} catch (Exception ex) {
			System.out.println("selectList error");
			ex.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return result;
	}
}
