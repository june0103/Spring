package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;

@Controller
public class BoardController {
	//로그 처리( 로그대상 지원)
	private Logger logging = Logger.getLogger(this.getClass());
	
	
	/*
	 * 로그레벨
	 * FATAL : 가장 심각한 오류
	 * ERROR : 일반적인오류
	 * WARN : 주의를 요구하는 경우
	 * INFO : 런타임시 관심 있는 내용
	 * DEBUG : 시스템 흐름과 관련된 상세 정보
	 * TRACE : 가장 상세한 정보
	 */
	
	//의존 관계 설정
	@Resource
	private BoardService boardService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	@RequestMapping("/list.do")
	public ModelAndView getList(@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		
		//총 레코드수
		int count = boardService.getBoardCount();
		
		if(logging.isDebugEnabled()) {
			logging.debug("count : " + count);
		}
		
		//페이징 처리					 선택한 현재 번호,  총갯수, 한페이지의 게시물갯수, 한 화면에 보여지는 페이지 수, 호출페이지 URL
		PagingUtil page = new PagingUtil(currentPage, count, 10, 10, "list.do");
		
		//목록 호출
		List<BoardVO> list = null;
		if(count > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			list = boardService.getBoardList(map);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		//데이터 저장
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		return mav;
	}
	
	//글쓰기
	@RequestMapping(value="/insert.do",method=RequestMethod.GET)
	public String form() {
		return "insertForm";
	}
	
	//글쓰기 처리
	@RequestMapping(value="/insert.do",method=RequestMethod.POST)
	public String submit(@Valid BoardVO boardVO,
			             BindingResult result) {
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//글쓰기
		boardService.insertBoard(boardVO);
		
		return "redirect:/list.do";
	}
	
	//글 상세
	@RequestMapping("/detail.do")
	public ModelAndView detail(@RequestParam int num) {
		BoardVO board = boardService.getBoard(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectDetail");
		mav.addObject("board",board);
		return mav;
	}
	
	//글 수정 폼
	@RequestMapping(value="/update.do",method=RequestMethod.GET)
	public String formUpdate(@RequestParam int num, Model model) {
		
		BoardVO boardVO = boardService.getBoard(num);
		//데이터 저장
		model.addAttribute("boardVO", boardVO);
		return "updateForm";
	}
	
	//글 수정 처리
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid BoardVO boardVO, BindingResult result) {
		//유효성 체크 결과 오류가 있으면 폼을 호출
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		//비밀번호 일치 여부 체크를 위해 DB에 저장된 데이터를 호출
		BoardVO dbBoard = boardService.getBoard(boardVO.getNum());
		
		//비밀번호 체크
		if(!dbBoard.getPasswd().equals(boardVO.getPasswd())) {
			//비밀번호 불일치
			//벨리데이션 프로퍼티에 명시된 오류
			result.rejectValue("passwd", "invalidPassword");
			return "updateForm";
		}
		
		//글 수정 처리
		boardService.updateBoard(boardVO);
		
		return "redirect:/list.do";
	}
	
	//글 삭제 폼
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public String formDelete(@RequestParam int num, Model model) {
		//유효성 체크를 위해 자바빈 생성
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		
		model.addAttribute("boardVO",boardVO);
		
		return "deleteForm";
	}
	
	//글 삭제 처리
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public String submitDelete(@Valid BoardVO boardVO,BindingResult result) {
		//writer,title,content가 @NotEmpty로 데이터 전송이 필수로 이뤄져야 한다.
		//필수로 데이터 전송이 안되면 에러가 발생해 별도로 자바빈을 만들어야하지만 데이터가 많을수록 일이 많아지기에 무시한다
		//비밀번호가 전송되었는지만 체크
		if(result.hasFieldErrors("passwd")) {
			return "deleteForm";
		}
		
		//DB에 저장된 데이터를 읽어온다
		BoardVO dbBoard = boardService.getBoard(boardVO.getNum());
		
		//비밀번호 일치 여부 체크
		if(!dbBoard.getPasswd().equals(boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "deleteForm";
		}
		//글삭제
		boardService.deleteBoard(boardVO.getNum());
		
		
		return "redirect:/list.do";
	}
	
}




