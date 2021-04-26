package kr.spring.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch08.service.LoginCheckException;
import kr.spring.ch08.service.LoginService;
import kr.spring.ch08.validator.LoginVOValidator;
import kr.spring.ch08.vo.LoginVO;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	//의존 관계 설정
	@Autowired
	private LoginService loginService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public LoginVO initCommand() {
		return new LoginVO();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "login/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(LoginVO vo, BindingResult result) {
		
		System.out.println("전송된 데이터 : " + vo);
		
		//유효성 체크
		new LoginVOValidator().validate(vo, result);
		//유효성 체크 결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//로그인 체크
		try {
			//아이디와 비빌번호 일치 여부 체크
			loginService.checkLogin(vo);
			
			//정상적으로 로그인이 되면 
			//view 이름 맨 앞에 redirect:를 넣으면 리다이렉트 방식으로
			//view 호출
			return "redirect:/index.jsp";
			
		}catch(LoginCheckException e) {
			//로그인 실패시
			//에러 메시지 처리          에러코드
			result.reject("invalidIdOrPassword");
			return form();
		}
	}
}



