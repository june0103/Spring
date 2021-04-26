package kr.spring.ch12.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class LocaleChangeController {
	@Autowired
	private LocaleResolver localeResolver;
	
	@RequestMapping("/changeLanguage.do")
	public String change(@RequestParam("lang") String language,
			             HttpServletRequest request,
			             HttpServletResponse response) {
		
		Locale locale = new Locale(language);
		localeResolver.setLocale(request, response, locale);
		
		return "redirect:/index.jsp";
	}
	
}




