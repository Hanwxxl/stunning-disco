package member.model.service;

import java.sql.Connection;
import java.util.List;

import first.common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.MemberVo;

public class MemberService {
	
	// 1. Connection 생성
	// 2. Autocommit 설정 + commit + rollback (select문 제외, DML 여러개일때)
	// 3. DAO 메소드 호출 + 결과값
	// 4. Connection close
	
	public List<MemberVo> selectMemberList() {
		List<MemberVo> result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().selectMemberList(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	
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
