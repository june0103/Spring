package kr.spring.ch09.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch09.validator.SubmitReportValidator;
import kr.spring.ch09.vo.ReportVO;

@Controller
@RequestMapping("/report/submitReport.do")
public class SubmitReportController {

	//파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;
	
	//자바빈(VO) 초기화
	@ModelAttribute("report")
	public ReportVO initCommand() {
		return new ReportVO();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "report/submitReportForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("report") ReportVO vo,
			             BindingResult result)
	                                throws IOException{
		//유효성 체크
		new SubmitReportValidator().validate(vo, result);
		//에러가 있으면 폼을 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//파일 업로드
		File file = new File(path + "/" 
		             + vo.getReportFile().getOriginalFilename());
		vo.getReportFile().transferTo(file);
		
		System.out.println("주제 : " + vo.getSubject());
		System.out.println("업로드한 파일 : " 
		              + vo.getReportFile().getOriginalFilename());
		System.out.println("파일 용량 : " 
		                       + vo.getReportFile().getSize());
		
		return "report/submittedReport";
	}
	
	
	
}
