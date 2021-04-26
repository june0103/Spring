package kr.spring.ch13.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageReportController {
	@RequestMapping("/pageJsonReport.do")
	@ResponseBody
	public List<PageRank> jsonReport(){
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1,"/board/list.do"));
		pageRanks.add(new PageRank(2,"/board/write.do"));
		pageRanks.add(new PageRank(3,"/board/detail.do"));
		return pageRanks;
	}
}





