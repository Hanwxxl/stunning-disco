package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.common.jdbc.JdbcTemplate;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

public class MemberService {
	
	// 회원가입
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new MemberDao().enroll(conn, vo);
		JdbcTemplate.close(conn);
		return result;
		
		
	}
}