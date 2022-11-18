package kr.co.demo01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * Java 로 Oracle DB 에 접속하여 데이터 조회하는 방법
		 *     1. JDBC 라이브러리 필수
		 *          - JDBC 버전은 JDK 11 인 경우 OJDBC 10 이상을 사용.
		 *            JDK 8 인 경우 OJDBC 8 을 사용하면 됩니다.
		 *     2. JDBC 라이브러리를 이클립스 프로젝트의 설정에서 Java Build Path > Library > classPath
		 *        Add External JARs... 버튼 클릭하여 등록
		 *     3. 다음의 순서에 맞추어 코드 작성
		 *         A. Oracle Driver 등록
		 *         B. Database Connection 생성
		 *         C. Statement 객체 또는 PreparedStatement 객체 생성
		 *         D. Query 작성
		 *         E. 작성한 Query 전송 후 ResultSet 반환
		 *         F. 반환 받은 ResultSet 의 내용 추출 및 추가 작업
		 *         G. Database 관련 연결 정보 Close
		 */
		
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
		
		System.out.println("| ID  | FIRST_NAME      | LAST_NAME       | HIRE_DATE        |");
		System.out.println("+-----+-----------------+-----------------+------------------+");
		while(rs.next()) {
			int id = rs.getInt("EMPLOYEE_ID");
			String fName = rs.getString("FIRST_NAME");
			String lName = rs.getString("LAST_NAME");
			Date hireDate = rs.getDate("HIRE_DATE");
			
			System.out.printf("| %d | %15s | %15s | %s | \n", id, fName, lName, df.format(hireDate));
		}
		
		// Database 관련 연결 정보 Close
		rs.close();
		stat.close();
		conn.close();
	}

}
