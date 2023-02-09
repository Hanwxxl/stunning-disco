package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import first.common.JDBCTemplate;
import member.model.dao.MemberDao;

public class MemberService {
	
	// 1. Connection 생성
	// 2. Autocommit 설정 + commit + rollback (select문 제외, DML 여러개일때)
	// 3. DAO 메소드 호출 + 결과값
	// 4. Connection close

	
	// login
	public int login(String id, String pw) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		//DAO 메소드 호출
		result = new MemberDao().login(conn, id, pw);
		JDBCTemplate.close(conn);
		return result;
	}
	
}
