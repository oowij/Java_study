package ch07;

class A4{}

class B4{}
// 다중 상속은 안됨(예외로 인터페이스는 가능)
class C4 extends A4/*B4*/{
// 클래스는 안된다고	
}

// 인터페이스
interface D4{}
interface E4{}
interface F4 extends D4, E4{}

public class InheritanceEx4 {

	public static void main(String[] args) {

	}

}
