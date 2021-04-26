package kr.spring.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch07.validator.MemberInfoValidator;
import kr.spring.ch07.vo.MemberInfo;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {

	//자바빈(VO)초기화
	@ModelAttribute("vo")
	public MemberInfo initCommand() {
		return new MemberInfo();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "account/creationForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("vo") MemberInfo vo,
			             BindingResult result) {
		
		//전송된 데이터 유효성 체크
		new MemberInfoValidator().validate(vo, result);
		//BindingResult에 유효성 체크 결과 오류에 대한 내용이 저장되어
		//있으면 폼을 다시 호출
		if(result.hasErrors()) {
			return "account/creationForm";
		}
		
		return "account/created";
	}
	
}



