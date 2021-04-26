package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	//의존 관계 설정
	@Resource
	private SqlSessionTemplate sqlSession;
	
	//총 레코드 수
	public int getBoardCount() {
		Integer count = sqlSession.selectOne("getBoardCount");
		return count;
	}
	
	//목록
	public List<BoardVO> getBoardList(Map<String, Object> map){
		List<BoardVO> list = sqlSession.selectList("getBoardList",map);
		return list;
	}
	
	//글쓰기
	public void insertBoard(BoardVO board) {
		sqlSession.insert("insertBoard",board);
	}
	
	//글 상세
	public BoardVO getBoard(int num) {
		BoardVO boardVO = sqlSession.selectOne("getBoard",num);
		return boardVO;
	}
	
	//글 수정
	public void updateBoard(BoardVO board) {
		sqlSession.update("updateBoard", board);
	}
	
	//글 삭제
	public void deleteBoard(int num) {
		sqlSession.delete("deleteBoard",num);
	}
	
}



