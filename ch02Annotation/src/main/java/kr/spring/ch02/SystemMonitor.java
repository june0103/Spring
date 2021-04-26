package kr.spring.ch02;

import org.springframework.beans.factory.annotation.Autowired;

public class SystemMonitor {
	private int periodTime;
	private SmsSender sender;
	
	/* 
	 * @Autowired는 프로퍼티의 타입을 검사해서 자동 설정
	 * 생성자, 필드, 메서드에 지정 가능 
	 * 메서드에 지정할 때는 setXXX 뿐만 아니라 일반 메서드에도 적용 가능
	 * 
	 * @Autowired 어노테이션은 타입을 이용해서 자동적으로 프로퍼티 값을 설정하기 때문에,
	 * 해당 타입의 빈 객체가 존재하지 않거나 또는 빈 객체가 두 개이 이상 존재할 경우
	 * 스프링은 @Autowired 어노테이션이 적용된 빈 객체를 생성할 때 예외를 발생한다.
	 * 
	 * @Autowired는 필수 프로퍼티 체크가 기본값(@Autowired(required=true))
	 * 이고 필수 프로퍼티 체크가 하지 않을경우 @Autowired(required=false)
	 * 라고 명시하면 해당 타입의 빈 객체가 존재하지 않더라도 스프링은 예외를 발생하지 않는다
	 */
	
	public void setPeriodTime(int periodTime) {
		this.periodTime = periodTime;
	}
	@Autowired
	public void setSender(SmsSender sender) {
		this.sender = sender;
	}
	@Override
	public String toString() {
		return "SystemMonitor [periodTime=" + periodTime + ", sender=" + sender + "]";
	}
	
	

}
