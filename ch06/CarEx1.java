package ch06;
//package com.naver.untlle

//클래스 선언 : ch06.car1
//클래스: 객체를 만드는 룰(ex - 붕어빵 틀)
class Car1/*클래스명*/{
	
	//필드: 객체의 속성 <-무조건 ()가 없다.
	String carName;
	int velocity;
	String carColor;
	
	//메서드: 객체의 기능 <- 반드시  ()가 있다. 객체를 반복시키는 것
	void speedUp() {
		velocity++;
	}
	void speedDown() {
		velocity--;
		if(velocity<0)
			velocity=0;
	}
	void stop() {
		velocity = 0;
	}
}

//.Java로 선언된 클래스만 public 사용가능.
public class CarEx1 {

	public static void main(String[] args) {

		//클래스명 변수명; : 클래스의 객체를 참조하기 위한 참조변수를 선언
		//변수명 = new 클래스명(); : 클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장 
		//객체 생성
		Car1 c1 = new Car1();
		//Car1 c1; Car1 클래스 타입의 참조변수 c1을 선언:
		//c1 = new Car1(); : Car1인스턴스를 생성한 후, 생성된 Car1 인스턴스의 주소를 c1에 저장
		//new : 객체를 생성시켜주는 예약어
		c1.carName = "소나타";
		c1.carColor= "은색";
		c1.speedUp();		
		System.out.println(c1.carName);
		System.out.println(c1.carColor);
		System.out.println(c1.velocity);
	}

}
