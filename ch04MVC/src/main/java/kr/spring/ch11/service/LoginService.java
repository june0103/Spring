package kr.spring.ch11.service;

import kr.spring.ch11.vo.LoginVO;

public class LoginService {
	public void checkLogin(LoginVO vo) throws LoginCheckException{
		if(!vo.getUserId().equals(vo.getPassword())) {
			System.out.println("인증 실패 - " + vo.getUserId());
			
			throw new LoginCheckException();
		}
	}

}
