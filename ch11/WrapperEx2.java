package ch11;

public class WrapperEx2 {
	public static void main(String[] args) {
		char c1 = 'J';//문자인지
		System.out.println(c1);
		if(Character.isLetter(c1))
			System.out.println(" : 문자입니다.");
		char c2 = 'a';//대문장 인지 소문자 인지
		System.out.println(c2);
		if(Character.isLowerCase(c2))
			System.out.println(" : 소문자입니다.");
		char c3 ='2';//숫자인지
		System.out.println(c3);
		if(Character.isDigit(c3))
			System.out.println(" : 문자입니다.");
		char c4 = ' ';//공백인지
		System.out.println(c4);
		if(Character.isWhitespace(c4))
			System.out.println(" : 공백입니다.");		
	
		long l;
		Boolean b;
		Short s;
		double d;
		float f;
		byte bt;
		Integer i;
		Character c;
	
	}

}
