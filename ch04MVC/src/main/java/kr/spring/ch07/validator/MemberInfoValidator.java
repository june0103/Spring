package kr.spring.ch07.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch07.vo.MemberInfo;

public class MemberInfoValidator implements Validator{

	//Validator가 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	//인자로 전달된 자바빈(VO)의 프로퍼티에 저장된 데이터를 검증
	//target 객체에 대한 검증을 실행. 검증 결과 문제가 있을 경우 errors 객체에
	//어떤 문제가 있는지 정보를 저장.
	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo)target;
		if(memberInfo.getId() == null || 
				      memberInfo.getId().trim().isEmpty()) {
			                  //필드       에러코드
			errors.rejectValue("id", "required");
		}
		if(memberInfo.getName() == null || 
				     memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if(memberInfo.getAddress() == null || 
				     memberInfo.getAddress().trim().isEmpty()) {
			errors.rejectValue("address", "required");
		}
	}

}




