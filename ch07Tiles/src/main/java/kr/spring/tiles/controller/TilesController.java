package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	
	@RequestMapping("/index.do")
	public String process() {
		
			  //뷰이름(뷰타일스 식별자)
		return "index";
	}
	
	@RequestMapping("/company.do")
	public String getInfo() {
		return "company";
	}
	
	@RequestMapping("/item.do")
	public String getItem() {
		return "item";
	}
}
