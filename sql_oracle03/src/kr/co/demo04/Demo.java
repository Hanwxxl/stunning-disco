package kr.co.demo04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		// Oracle Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Database Connection 생성
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username = "dev01";
		String password = "dev01";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		
		// Query 작성(쿼리 문자열에 세미콜론은 넣지 마세요.)
		int empId = 207;
		String jobId = "IT_PROG";
		Date hireDate = new Date(new java.util.Date().getTime());

		String query = "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Statement 또는 PreparedStatement 객체 생성
		 PreparedStatement pstat = conn.prepareStatement(query);
		 pstat.setInt(1, empId);
		 pstat.setString(2, "길동");
		 pstat.setString(3,"홍");
		 pstat.setString(4,"HGILDONG");
		 pstat.setString(5,"515.123.1234");
		 pstat.setDate(6,hireDate);
		 pstat.setString(7, jobId);
		 pstat.setInt(8, 2800);
		 pstat.setDouble(9, 0);
		 pstat.setInt(10,103);
		 pstat.setInt(11, 60);
		 
		 // ㄴ 위 물음표에 하나씩 순서대로 대응됨.
		 
		
		// Query 전송 후 결과 저장
		int rs = pstat.executeUpdate();
		
		if(rs >= 1) {
			System.out.println(rs + " 개 행이 반영되었습니다.");
		} else {
			System.out.println("0개 행이 반영되었습니다. (쿼리에 문제있는 것 같습니다. 다시 확인하세요.");
		}
	
		
		// Database 관련 연결 정보 Close
		pstat.close();
		conn.close();
	}

}




