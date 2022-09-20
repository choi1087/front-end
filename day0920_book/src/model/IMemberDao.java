package model;

import java.sql.SQLException;

public interface IMemberDao {
	int insert(Member member) throws SQLException ; // 회원가입
	Member selectOne(String id, String pw) throws SQLException ; // 로그인
}