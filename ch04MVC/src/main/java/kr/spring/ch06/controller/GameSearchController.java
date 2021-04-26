package kr.spring.ch06.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.ch06.service.GameSearchService;
import kr.spring.ch06.vo.GameSearchVO;

@Controller
public class GameSearchController {
	//의존관계 설정
	@Resource
	private GameSearchService gameSearchService;
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(
			            @ModelAttribute("vo") GameSearchVO vo) {
		
		System.out.println("전송된 데이터 : " + vo);
		
		//GameSearchService 호출
		String result = gameSearchService.search(vo);
		
		                                     //뷰 이름
		ModelAndView mav = new ModelAndView("search/game");
		               //속성명              속성값
		mav.addObject("searchResult",result);
		
		return mav;
	}
	
}
