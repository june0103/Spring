package kr.spring.ch04.service;

import kr.spring.ch04.vo.OrderVO;

public class OrderService {
	public void processOrder(OrderVO vo) {
		System.out.println("데이터베이스에 데이터 저장 완료 : " + vo);
	}
}
