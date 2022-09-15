package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	public StudentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 오류");
		}
	}

	public int insert(Student student) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String url = "jdbc:mysql://localhost:3306/ssafy_8th";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");

			String sql = "INSERT INTO STUDENT_TB(NAME, AGE, ADDRESS) ";
			sql += "VALUES(?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getAge());
			pstmt.setString(3, student.getAddress());

			// 5. SQL 실행
			result = pstmt.executeUpdate();

			// 6. 결과값 확인(int는 간단하지만 ResultSet은 파싱같은 것을 해야함)
			System.out.println("dao insert success: " + result);
		} catch (SQLException e) {
			System.out.println("insert 에러");
			e.printStackTrace(); // 이거 지우면 나중에 디버깅 죽어남
		} finally {
			// 7. 사용한 자원 반납 close
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	
	public List<Student> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Student> result = new ArrayList<>();
		try {
			String url = "jdbc:mysql://localhost:3306/ssafy_8th";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");

			String sql = " SELECT NO, NAME, AGE, ADDRESS " + " FROM STUDENT_TB ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setNo(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
				s.setAddress(rs.getString(4));
				result.add(s);
			}
			System.out.println("dao selectAll success: " + result);
		} catch (SQLException e) {
			System.out.println("selectAll 에러");
			e.printStackTrace(); // 이거 지우면 나중에 디버깅 죽어남
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}
}
