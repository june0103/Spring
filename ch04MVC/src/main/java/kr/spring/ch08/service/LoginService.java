package kr.spring.ch08.service;

import kr.spring.ch08.vo.LoginVO;

public class LoginService {
	public void checkLogin(LoginVO loginVO) 
	                        throws LoginCheckException{
		//테스트용으로 userId와 password가 일치하면 로그인 처리
		if(!loginVO.getUserId().equals(loginVO.getPassword())) {
			//테스트용으로 userId와 password가 불일치하면 예외 발생
			
			System.out.println("인증 에러 - " + loginVO.getUserId());
			
			throw new LoginCheckException();
		}
	}
}
