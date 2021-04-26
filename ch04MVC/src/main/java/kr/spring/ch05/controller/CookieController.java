package kr.spring.ch05.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		//쿠키 생성                                  쿠키명     쿠키값
		Cookie cookie = new Cookie("auth","1");
		//생성한 쿠키를 클라이언트로 전송
		response.addCookie(cookie);
		
		return "cookie/make";
	}
	
	@RequestMapping("/cookie/view.do")
	public String view(
		@CookieValue(value="auth",defaultValue="0") String auth) {
		
		/*
		 * @CookieValue 어노테이션을 이용하면 쿠키 값을 파라미터로 전달받을 수
		 * 있음.
		 * 해당 쿠키가 존재하지 않으면 기본적으로 400에러를 발생시킴.
		 * @CookieValue(value="auth",required=false)로 지정했을 경우
		 * 쿠키가 존재하지 않으면 null값으로 전달
		 * @CookieValue(value="auth",defaultValue="0")로 지정했을
		 * 경우 쿠키가 존재하지 않으면 defaultValue에 지정한 값을 사용
		 */
		
		System.out.println("auth 쿠키 : " + auth);
		
		return "cookie/view";
	}
	
	
}






