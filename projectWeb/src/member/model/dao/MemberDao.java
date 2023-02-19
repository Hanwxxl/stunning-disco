package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import first.common.JdbcTemplate;
import member.model.vo.MemberVo;

public class MemberDao {
	
	
	// 로그인
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		String sql = "select userID, userPassword from project_t where userID=? and userPassword=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberVo();
				result.setUserID(rs.getString("userID"));
				result.setUserPassword(rs.getString("userPassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}	
		System.out.println(result);		
		return result;
	}

		
		
		//회원가입
		public int enroll(Connection conn, MemberVo vo) {
			int result = -1;
			String query = "insert into project_t values ";
			query += " (?,?,?,?)";
			
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);	
				pstmt.setString(1, vo.getUserID());
				pstmt.setString(2, vo.getUserPassword());
				pstmt.setString(3, vo.getUserName());
				pstmt.setString(4, vo.getUserEmail());
		
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