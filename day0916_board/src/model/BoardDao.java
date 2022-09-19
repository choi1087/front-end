package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public int insert(BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();
			String sql = "insert into board_tb(title, writer, content, write_date)\r\n" + "values(?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			result = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("insert error");
			ex.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<BoardDTO> selectList(int startRow, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BoardDTO> result = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();
			String sql = "select bno, title, writer, write_date, read_count\r\n"
					+ "from board_tb order by bno desc limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setWriteDate(rs.getString(4));
				b.setReadCount(rs.getInt(5));
				result.add(b);
			}
		} catch (Exception ex) {
			System.out.println("selectList error");
			ex.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	public int selectTotalCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();
			String sql = "select count(*) from board_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next(); // th�κ�
			result = rs.getInt(1);
		} catch (Exception ex) {
			System.out.println("selectTotalCount error");
			ex.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	public BoardDTO selectOne(int bno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardDTO result = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();
			String sql = "select bno, title, writer, content, write_date, read_count\r\n"
					+ "from board_tb where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setContent(rs.getString(4));
				b.setWriteDate(rs.getString(5));
				b.setReadCount(rs.getInt(6));

				result = b;
			}

		} catch (Exception ex) {
			System.out.println("selectOne error");
			ex.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	public int updateReadCount(int bno) {
		System.out.println("updateReadCount");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();
			String sql = "update board_tb set read_count = read_count + 1 where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("updateReadCount error");
			ex.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	public void delete(int bno) {
		System.out.println("delete");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();
			String sql = "delete from board_tb where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("updateReadCount error");
			ex.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}
}
