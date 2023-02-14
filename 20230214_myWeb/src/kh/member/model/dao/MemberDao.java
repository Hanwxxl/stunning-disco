package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static kh.common.jdbc.JdbcTemplate.*;
import kh.common.jdbc.JdbcTemplate;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	
	
	// 회원가입 - Connection conn 넣는거 잊지말기
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query = "insert into Test_Member values ";
		query += " (?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
		   pstmt = conn.prepareStatement(query);
		   // ? 채워주기
		   pstmt.setString(1, vo.getId());
		   pstmt.setString(2, vo.getPasswd());
		   pstmt.setString(3, vo.getName());
		   pstmt.setString(4, vo.getEmail());
		   
		   // pstmt 실행하기
		   // 결과값 result에 대입
		   result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println("DAO enroll() return: "+ result);
		return result;
	}
}
