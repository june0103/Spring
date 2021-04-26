package kr.spring.ch09.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch09.vo.ReportVO;

public class SubmitReportValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ReportVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ReportVO vo = (ReportVO)target;
		if(vo.getSubject() == null || 
				vo.getSubject().trim().isEmpty()) {
			errors.rejectValue("subject", "required");
		}
		if(vo.getReportFile() == null ||
				vo.getReportFile().isEmpty()) {
			errors.rejectValue("reportFile", "required");
		}
		
	}

}
