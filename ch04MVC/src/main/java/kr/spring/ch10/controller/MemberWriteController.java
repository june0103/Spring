package kr.spring.ch10.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch10.vo.MemberVO;

@Controller
public class MemberWriteController {

	//자바빈(VO) 초기화
	@ModelAttribute("vo")
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	@RequestMapping(value="/member/write.do",method=RequestMethod.GET)
	public String form() {
		return "member/write";
	}
	
	@RequestMapping(value="/member/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("vo") @Valid MemberVO memberVO,
			             BindingResult result) {
		
		//유효성 체크 결과 에러가 있으면 폼을 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//에러가 없이 정상적으로 데이터가 처리되면 index.jsp를 리다이렉트		
		return "redirect:/index.jsp";
	}
	
}






