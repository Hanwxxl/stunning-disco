package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import first.common.JDBCTemplate;
import member.model.vo.MemberVo;

public class MemberDao {
	
	
	//로그인
	public int login(Connection conn, String id, String pw) {
		int result = -1; 
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryForStatement = "select count(*) cnt from project_T where userID='"+id+"' and userPassword='"+pw+"'"; 
		String queryForPreParedStatement = "select count(*) cnt from project_T where userID = ? and userPassword = ?";                             // 별칭 꼭 적어주기
	
	
		try {

			pstmt = conn.prepareStatement(queryForPreParedStatement);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
							
					
			if(rs.next()) {
				rs.getInt("cnt");
				result = rs.getInt("cnt");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
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
				JDBCTemplate.close(pstmt);
			}
			System.out.println("DAO enroll() return: "+ result);
			return result;
	}
}