package kr.spring.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//설정파일에 <context:component-scan> 태그를 추가하면 스프링은 지정한 패키지에서 @Component 어노테이션이 적용된 클래스를 검색하여 빈 객체로 등록

//자동으로 등록된 빈의 아이디는 클래스 이름의 첫 글자를 소문자로 바꿔서 사용함
//예)클래스명이 HomeController - 빈의 이름은 homeController

//빈의 이름을 지정하고 싶으면 @Component("home")와 같이 명시함 또는
//@Component
//@named("home")도 가능하다
@Component
public class HomeController {
	@Autowired
	private Camera camera;

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "HomeController [camera=" + camera + "]";
	}
	
	

}
