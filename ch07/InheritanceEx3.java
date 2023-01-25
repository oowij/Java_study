package ch07;

class Car3{
	public Car3() {
		super();
	}
	void speedUp() {
	}
}	
class Taxi3 extends Car3{
	void stop() {}
}

public class InheritanceEx3 {
	public static void main(String[] args) {
		new Car3();
		Object obj = new Car3();
//		obj.speedUp();   오브젝트는 래퍼런스 즉 가리킬 수 있음
		Car3 c = new Taxi3();
//		Taxi3 t = new Car3();
	}

}
