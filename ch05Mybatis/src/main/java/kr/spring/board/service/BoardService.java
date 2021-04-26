package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardDAO;
import kr.spring.board.vo.BoardVO;

@Service("boardService")
public class BoardService {
	//의존 관계 설정
	@Resource
	private BoardDAO boardDAO;
	
	//총 레코드 수
	public int getBoardCount() {
		return boardDAO.getBoardCount();
	}
	
	//목록
	public List<BoardVO> getBoardList(Map<String, Object> map){
		return boardDAO.getBoardList(map);
	}
	
	//글쓰기
	public void insertBoard(BoardVO board) {
		boardDAO.insertBoard(board);
	}
	
	//글 상세
	public BoardVO getBoard(int num) {
		return boardDAO.getBoard(num);
	}
	
	//글 수정
	public void updateBoard(BoardVO board) {
		boardDAO.updateBoard(board);
	}
	
	//글 삭제
	public void deleteBoard(int num) {
		boardDAO.deleteBoard(num);
	}
	
}



