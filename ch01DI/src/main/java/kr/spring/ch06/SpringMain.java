package kr.spring.ch06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext(
						               "applicationContext.xml");
		//DI 생성자 설정 방식으로 생성된 객체를 읽어들임
		MemberBean member = 
				    (MemberBean)context.getBean("memberBean");
		member.setMember();
		
		//어플리케이션 종료시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
	}
}




