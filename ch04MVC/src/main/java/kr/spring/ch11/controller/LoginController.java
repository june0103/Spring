package kr.spring.ch11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch11.service.LoginCheckException;
import kr.spring.ch11.service.LoginService;
import kr.spring.ch11.validator.LoginValidator;
import kr.spring.ch11.vo.LoginVO;

@Controller
public class LoginController {
	//의존 관계 설정
	@Autowired
	private LoginService loginService;
	
	//자바빈(VO) 초기화
	@ModelAttribute("login")
	public LoginVO initCommand() {
		return new LoginVO();
	}
	
	@RequestMapping(value="/login2/login.do",method=RequestMethod.GET)
	public String form() {
		return "login2/loginForm";
	}
	
	@RequestMapping(value="/login2/login.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginVO loginVO,
			             BindingResult result) {
		//유효성 체크
		new LoginValidator().validate(loginVO, result);
		//유효성 체크 결과 에러가 있으면 폼을 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//로그인 체크
		try {
			//LoginService 호출
			loginService.checkLogin(loginVO);
			
			return "login2/loginSuccess";
			
		}catch(LoginCheckException e) {
			//인증 실패
			//에러 메시지 처리
			result.reject("invalidIdOrPassword");
			return form();
		}
	}
	
}






