package common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	
	public static Connection getconnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys","oracle");
		} catch (ClassNotFoundException e) {
			System.out.println("~~~~~  ojdb jar 없어요 ~~~~");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("~~~~~ 연결 실패 ~~~~");
			e.printStackTrace();
		} finally {
			if(conn == null) {
				System.out.println("~~~~ null연결실패 ~~~~");
			} else {
				System.out.println("연결성공");
			}
		}
		return conn;
	}

}
