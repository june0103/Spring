package kr.spring.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextScan.xml");
		
		HomeController home = (HomeController)context.getBean("homeController");
		System.out.println(home);
		
		context.close();
	}
}
