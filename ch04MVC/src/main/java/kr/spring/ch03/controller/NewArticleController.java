package kr.spring.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.ch03.vo.NewArticleVO;

@Controller
public class NewArticleController {

	@RequestMapping("/article/newArticleForm.do")
	public String form() {
		        // 뷰 이름
		return "article/newArticleForm";
	}
	/*
	 * @ModelAttribute를 이용하면 자바빈(VO)를 생성해서 자바빈의 프로퍼티(멤버변수)와
	 * request에 저장된 파라미터명을 대조해서 일치하면 데이터를 셋팅
	 * 
	 * @ModelAttribute("vo") ->  request.setAttribute("vo",생성한 자바바빈 객체)
	 * @ModelAttribute -> request.setAttribute("newArticleVO",생성한 자바바빈 객체)
	 * 
	 * @ModelAttribute는 생략 가능함. 
	 * 예)메서드의 인자로 NewArticleVO vo 라고 명시하면
	 * 자바빈 객체를 생성한 후 자바빈에 전송된 데이터를 저장하고 request에
	 * 속성명 newArticleVO하고 자바빈을 저장함
	 */
	@RequestMapping("/article/newArticle.do")
	public String submit(NewArticleVO vo) {
		
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("이름 : " + vo.getName());
		System.out.println("내용 : " + vo.getContent());
		
		return "article/newArticleSubmitted";
	}
	
}



