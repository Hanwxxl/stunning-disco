package member.model.service;

import java.sql.Connection;

import first.common.JdbcTemplate;
import member.model.dao.MemberDao;
import member.model.vo.MemberVo;

public class MemberService {
	
	// 로그인
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new MemberDao().login(conn, vo);
		JdbcTemplate.close(conn);
		return result;
	}
		

	// 회원가입
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new MemberDao().enroll(conn, vo);
		JdbcTemplate.close(conn);
		return result;

	
	}
}

