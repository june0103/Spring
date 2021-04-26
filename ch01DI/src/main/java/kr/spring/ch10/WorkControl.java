package kr.spring.ch10;

public class WorkControl {
	private long periodTime;
	private EmailSender email;
	
	//DI 프로퍼티 설정 방식
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
	}
	public void setEmail(EmailSender email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "WorkControl [periodTime=" + periodTime + ", email=" + email + "]";
	}
}


