package ch02;

public class Ex2 {

	public static void main(String[] args) {
		//변수는 위에 선언한 것은 밑에 사용가능
		//int b = a;
		//int a = 10;
		//위에는 안된다는 말
		
		//이렇게는 가능
		int a = 10;
		int b = a;
		if(a>10) {
			int c = 10;
		}
		//int d = c;
	}
}
