package kr.spring.ch01;

import org.springframework.beans.factory.annotation.Required;

public class Camera {
	private int number;

	//@Required 어노테이션을 이용한 필수 프로퍼티 검사
	//메서드에만 표시 가능, 프로퍼티에 표시 불가능
	@Required
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Camera [number=" + number + "]";
	}
	
	
}
