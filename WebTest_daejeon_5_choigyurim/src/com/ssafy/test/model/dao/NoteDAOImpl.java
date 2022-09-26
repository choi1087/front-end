package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.dto.NoteDto;
import com.ssafy.test.util.DBUtil;

public class NoteDAOImpl implements NoteDAO {

	private static NoteDAOImpl noteDAO = new NoteDAOImpl();

	public static NoteDAOImpl getDao() {
		return noteDAO;
	}

	private DBUtil dbUtil;

	public NoteDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}

	@Override
	public boolean insert(NoteDto noteDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			String sql = "insert into note(noteCode, model, price, company) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noteDto.getNoteCode());
			pstmt.setString(2, noteDto.getModel());
			pstmt.setInt(3, noteDto.getPrice());
			pstmt.setString(4, noteDto.getCompany());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("note insert error");
			e.printStackTrace();
			return false;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return true;
	}

	@Override
	public List<NoteDto> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoteDto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String sql = "select noteCode, model, price, company from note";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoteDto n = new NoteDto();
				n.setNoteCode(rs.getString(1));
				n.setModel(rs.getString(2));
				n.setPrice(rs.getInt(3));
				n.setCompany(rs.getString(4));
				list.add(n);
			}
		} catch (Exception e) {
			System.out.println("note selectList error");
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public NoteDto selectOne(String codeNote) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoteDto noteDto = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "select noteCode, model, price, company from note where noteCode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, codeNote);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				noteDto = new NoteDto();
				noteDto.setNoteCode(rs.getString(1));
				noteDto.setModel(rs.getString(2));
				noteDto.setPrice(rs.getInt(3));
				noteDto.setCompany(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println("note selectOne error");
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return noteDto;
	}

	@Override
	public void delete(String codeNote) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "delete from note where noteCode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, codeNote);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("note delete error");
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

	}

}
