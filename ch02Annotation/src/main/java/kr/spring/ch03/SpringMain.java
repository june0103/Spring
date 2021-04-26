package kr.spring.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//@Autowired 어노테이션을 이용한 자동 설정
		SystemMonitor2 monitor = (SystemMonitor2)context.getBean("systemMonitor");
		System.out.println(monitor);
			
		context.close();
	}

}
