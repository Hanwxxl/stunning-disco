package board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	
	private Connection conn;
	private ResultSet rs; 
	
	public BoardDao() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "KH";
			String dbPassword = "KH";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public String getDate() {
//		String SQL = "SELECT sysdate from dual";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(SQL);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				return rs.getString(1);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return ""; //DB 오류 
//	}
	
	public int getNext() {
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류 
	}

	public int write(String bbsTitle, String userID, String bbsContent){
		String SQL = "INSERT INTO BBS VALUES (?, ?, ?, sysdate, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			//pstmt.setString(4, getDate());
			pstmt.setString(4, bbsContent);
			pstmt.setInt(5, 1);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류 
	}
}
