package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.BookmarkDTO;

public class BookmarkDAO {
	
	private SqlSession session = OracleConnection.getSqlSession();

	public List<BookmarkDTO> selectAll() {
		List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectAll");  //mapperNamespace.id
		
		return data;
	}

	public int insert(BookmarkDTO dto) {   //반환타입 int
		int count = session.insert("bookmarkMapper.insert", dto);
		return count;
		
	}
	
	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();

}
}








