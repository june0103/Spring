package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.vo.BoardVO;

@Service("boardService")
public class BoardService {
	@Resource
	BoardMapper boardMapper;
	
	//총 레코드 수
	public int getBoardCount() {
		return boardMapper.getBoardCount();
	}
	//목록
	public List<BoardVO> getBoardList(Map<String, Object> map) {
		return boardMapper.getBoardList(map);
	}
	
	//글 상세
	public BoardVO getBoard(int num) {
		return boardMapper.getBoard(num);
	}
	
	//글쓰기
	public void insertBoard(BoardVO board) {
		boardMapper.insertBoard(board);
	}
	
	//글 수정
	public void updateBoard(BoardVO board) {
		boardMapper.updateBoard(board);
	}
	
	//글 삭제
	public void deleteBoard(int num) {
		boardMapper.deleteBoard(num);
	}
	
	
}
