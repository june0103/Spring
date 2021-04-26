package kr.spring.ch04;

import javax.annotation.Resource;

public class HomeController {
	//프로퍼티명과 빈의 이름이 일치하면 의존 관계 설정
	@Resource
	private Camera camera2;
	@Resource(name="cameraz")
	private Camera camera3;
	private Camera camera4;
	
	public void setCamera2(Camera camera2) {
		this.camera2 = camera2;
	}
	public void setCamera3(Camera camera3) {
		this.camera3 = camera3;
	}
	@Resource
	public void setCamera4(Camera camera4) {
		this.camera4 = camera4;
	}
	@Override
	public String toString() {
		return "HomeController [camera2=" + camera2 + ", camera3=" + camera3 + ", camera4=" + camera4 + "]";
	}

}
