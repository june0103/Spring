package kr.spring.ch04.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch04.service.OrderService;
import kr.spring.ch04.vo.OrderVO;

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	
	/*
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}*/

	@RequestMapping(value="/order/order.do",method=RequestMethod.GET)
	public String form() {
		return "order/orderForm";
	}
	
	@RequestMapping(value="/order/order.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("vo") OrderVO vo) {
		
		//OrderService 호출
		orderService.processOrder(vo);
		
		return "order/orderCompletion";
	}
	
}



