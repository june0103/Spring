package kr.spring.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	/*
	 * @RequestParam 어노테이션은 HTTP 요청 파라미터를 메서드의 파라미터로 전달
	 * query는 필수적으로 전달해야 하는 데이터이기 때문에 query 미전달시 오류
	 * 
	 * @RequestParam(파라미터명) 사용하는데 메서드의 인자명이 파라미터명과 동일하면
	 * 파라미터명 생략 가능
	 * 
	 * 파라미터명과 인자명을 동일하게 명시하면 @RequestParam도 생략 가능
	 * @RequestParam 어노테이션을 생략했을 경우 query가 전달되지 않아도 오류가
	 * 발생하지 않고 null로 인식
	 * 
	 */
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(String query,
			@RequestParam("p") int pageNumber) {
		
		System.out.println("query : " + query 
				               + ",pageNumber : " + pageNumber);
		
		                           //뷰 이름
		return new ModelAndView("search/internal");
	}
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(
	    @RequestParam(value="query",required=false) String query,
	    @RequestParam(value="p", defaultValue="1") int pageNumber) {
		
		System.out.println("query : " + query 
				              + ",pageNumber : " +pageNumber);
		
		                         //뷰 이름
		return new ModelAndView("search/external");
	}
	
	
}



