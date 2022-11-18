package kr.co.demo05;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import kr.co.db.vo.EmployeeVO;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Oracle Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Database Connection 생성
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username = "dev01";
		String password = "dev01";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// Statement 또는 PreparedStatement 객체 생성
		Statement stat = conn.createStatement();
		// PreparedStatement pstat = conn.prepareStatement("");
		
		// Query 작성(쿼리 문자열에 세미콜론은 넣지 마세요.)
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES";
		
		// Query 전송 후 결과 저장
		ResultSet rs = stat.executeQuery(query);
		
		// ResultSet 에서 값 추출
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		ArrayList<EmployeeVO> empArray = new ArrayList<EmployeeVO>();
		
		while(rs.next()) {
			EmployeeVO emp = new EmployeeVO();
			emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
			emp.setFirstName(rs.getString("FIRST_NAME"));
			emp.setLastName(rs.getString("LAST_NAME"));
			emp.setHireDate(rs.getDate("HIRE_DATE"));
			empArray.add(emp);
		}
		
		System.out.println(empArray);
		
		// Database 관련 연결 정보 Close
		rs.close();
		stat.close();
		conn.close();
	}

}
