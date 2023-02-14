package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import first.common.JDBCTemplate;
import member.model.vo.MemberVo;

public class MemberDao {
	
	public List<MemberVo> selectMemberList(Connection conn){
		List<MemberVo> result = null;
		
		String query = "select * from test_member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
		if(rset.next()) {
			result = new ArrayList<MemberVo>();
			do {
				String id = rset.getString("id");
				String passwd = rset.getString("passwd");
				String name = rset.getString("name");
				String email = rset.getString("email");
				MemberVo vo = new MemberVo();
				vo.setEmail(email);
				vo.setId(id);
				vo.setName(name);
				vo.setPasswd(passwd);
				result.add(vo);
			}while(rset.next());	
		}
		} catch (Exception e){
			e.printStackTrace();			
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	

	public int login(Connection conn, String id, String pw) {
		int result = -1;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryForStatement = "select count(*) cnt from test_member where id='"+id+"' and passwd='"+pw+"'";
		String queryForPreparedStatement = "select count(*) cnt from test_member where id=? and passwd=?";
		// query문 실행
		try {
			// 1. Statement방식
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(queryForStatement);
			
			
			// 2. PreparedStatement 방식
			pstmt = conn.prepareStatement(queryForPreparedStatement);
			// placeholder ? 있다면 여기서 값 채우기
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}			
//			stmt.executeQuery("SELECT문 DQL실행");
//			stmt.executeUpdate("INSERT/ UPDATE/ DELETE 명령문 DML 실행할때");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs); // Select문 DQL실행
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
}
