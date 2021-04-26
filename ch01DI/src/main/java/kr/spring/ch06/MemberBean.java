package kr.spring.ch06;

public class MemberBean {
	private RegisterBean registerBean;
	
	//의존 관계 설정 : 생성자 방식
	public MemberBean(RegisterBean registerBean) {
		this.registerBean = registerBean;
	}
	
	public void setMember() {
		System.out.println("MemberBean : 회원 정보 입력");
		
		registerBean.register();
	}
}
