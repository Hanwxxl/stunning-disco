package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.BookmarkDTO;

public class BookmarkDAO {
	
	private SqlSession session = OracleConnection.getSqlSession();
	
	/**
	 * 데이터베이스에 저장할 데이트의 식별값을 생성하기 위한 메서드
	 * @return id
	 */
	
	public int getId() {
		int id = session.selectOne("bookmarkMapper.getId");
		return id;
	}
	
	public BookmarkDTO selectId(int id) {
		BookmarkDTO data = session.selectOne("bookmarkMapper.selectId",id);
		System.out.println(data);
		return data;
	}

	public List<BookmarkDTO> selectAll() {
		List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectAll");  //mapperNamespace.id
		
		return data;
	}

	public int insert(BookmarkDTO dto) {   //반환타입 int
		int count = session.insert("bookmarkMapper.insert", dto);
		return count;
		
	}
	
	public int update(BookmarkDTO dto) {
		int count = session.update("bookmarkMapper.update",dto);
		return count;
	}
	
	public int delete(BookmarkDTO dto) {
		int count = session.delete("bookmarkMapper.delete", dto);
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








