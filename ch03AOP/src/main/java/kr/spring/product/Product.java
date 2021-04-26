package kr.spring.product;

public class Product {
	//핵심기능수행
	public String launch() {
		System.out.println("launch() 메서드 출력");
		
		//예외발생시 호출되는 공통 코드를 테스트하기 위해
		System.out.println(20/0);
		
		return "[상품출시]";
	}
}
