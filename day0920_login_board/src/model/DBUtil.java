package model;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

public class DBUtil {
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/ssafy_8th";
	static final String dbUser = "ssafy";
	static final String dbPw = "ssafy";

	static {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		}
	}

	static Connection makeConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, dbUser, dbPw);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
