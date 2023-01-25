package ch07;

abstract class Abstract2{
	public void prn() {
		
	}
}

abstract class Abstract2_1 extends Abstract2{
	public void prn2(){
		
	}
}
class Normal2 extends Abstract2_1{
	@Override
	public void prn() {
		
	}
	public void prn2() {
		
	}
}

public class AbstractEx2 {

	public static void main(String[] args) {

	}

}
