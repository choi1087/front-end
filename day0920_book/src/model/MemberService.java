package model;

import java.sql.SQLException;

public class MemberService {
	private MemberDao memberDao = new MemberDao();

	public boolean insert(Member member) {
		try {
			if (memberDao.insert(member) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Member selectOne(String id, String pw) {
		Member member = null;
		try {
			member = memberDao.selectOne(id, pw);
		} catch (SQLException e) {
			member = null;
			e.printStackTrace();
		}
		return member;
	}
}
