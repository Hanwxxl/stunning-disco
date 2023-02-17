package first.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	private static JDBCTemplate instance;
	
	private JDBCTemplate() {}
	
	public static JDBCTemplate getInstance() {
		if(instance == null) {
			instance = new JDBCTemplate(); 
	}
		return instance;
		
	}
	
	// JDBC클래스 로드
	public static Connection getConnection() {
		Connection conn = null; //try문 안에서는 선언x, catch와 finally만 쓸 수 없으므로
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
	} catch (ClassNotFoundException e){
		System.out.println("!!!! odjbc jar 없어요 !!!!");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("!!!! 연결실패 !!!!");
		e.printStackTrace();
	} finally {
		if(conn == null) {
			System.out.println("!!!!! null연결실패 !!!!!");
		}else {
			System.out.println("연결성공");
		}
	}
		return conn;
	}

	public static void close(Connection conn) {
			try {   
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	public static void close(Statement stmt) {
		try {   
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {   
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}

