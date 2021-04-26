package kr.spring.ch09;

public class SystemMonitor {
	private long periodTime;
	private SmsSender sender;
	//DI 프로퍼티 설정
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
	}
	public void setSender(SmsSender sender) {
		this.sender = sender;
	}
	@Override
	public String toString() {
		return "SystemMonitor [periodTime=" + periodTime + ", sender=" + sender + "]";
	}
}
