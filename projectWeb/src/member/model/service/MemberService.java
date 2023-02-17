package member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import first.common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.MemberVo;

public class MemberService {
	
	// 로그인
	public int login(String id, String pw) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection(); 
		
		result = new MemberDao().login(conn, id, pw);		
		
		JDBCTemplate.close(conn);
		return result;
	}
		

	// 회원가입
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().enroll(conn, vo);
		JDBCTemplate.close(conn);
		return result;

	
	}
	}