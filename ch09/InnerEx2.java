package ch09;

class Outer2{
	int a =22;
	
	void p() {
		System.out.println("a"+a);
		//내부 클래스는 외부클래스 내에서만 일반적으로 사용하고 
		//상당히 밀접한 관계가 있는 기능의 클래스로 선언
	}
	class Inner2{
		int b =23;
		void p1() {
			p();
			System.out.println("a + b =" + (a+b));
		}
	}//Inner2
}


public class InnerEx2 {
	public static void main(String[] args) {
		//일반적으로 내부클래스는 다른 클래스에서 생성하고 사용하는 것응 거의 없음
		//제3의 클래스에서 사용버
		Outer2 out = new Outer2();
		Outer2.Inner2 in = out.new Inner2();
		
	}

}
