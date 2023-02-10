package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BookmarkDAO;
import model.dto.BookmarkDTO;

public class BookmarkService {

	public List<BookmarkDTO> getAll(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectAll(dto);
		dao.close();
		return data;
	}
	
	public List<BookmarkDTO> getPage(BookmarkDTO dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 2);
		map.put("end", 3);
		map.put("userId", dto.getUserId());
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectPage(map);
		dao.close();
		return data;
	}

	public boolean add(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		
		int id = dao.getId();
		dto.setId(id);
		
		int rowCount = dao.insert(dto);
		if(rowCount == 1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public BookmarkDTO get(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		BookmarkDTO data = dao.selectId(dto);
		return data;
	}

	public boolean update(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int count = dao.update(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public boolean remove(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int count = dao.delete(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

}
