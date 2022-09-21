package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.model.dao.MemberDao;

public class MemberService {
	private MemberService() {

	}

	private static MemberService service = new MemberService();

	public static MemberService getService() {
		return service;
	}

	private MemberDao dao = MemberDao.getInstance();

	public int insert(Member member) throws SQLException {
		return dao.insert(member);
	}

	public Member login(String id, String pw) throws Exception {
		Member member = dao.selectOne(id, pw);
		if (member == null) {
			throw new Exception("아이디 또는 패스워드가 틀렸습니다.");
		}
		return member;
	}

	public void removeMember(int no) throws SQLException {
		dao.delete(no);
	}
}
