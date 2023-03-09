package member.model.service;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.BoardVo;
import first.common.JdbcTemplate;

public class BoardService {

		public List<BoardVo> getBoardList(){
			List<BoardVo> result = null;
			Connection conn = JdbcTemplate.getConnection();
			result = new BoardDao().getBoardList(conn);
			System.out.println("srv:"+ result);
			JdbcTemplate.close(conn);
			return result;
		}
}
