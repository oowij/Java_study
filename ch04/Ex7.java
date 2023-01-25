package ch04;

public class Ex7 {
	int b;

	public static void main(String[] args) {
		//for문을 이용해서 1~10까지의 합을 구하시오.
		int sum = 0;
		/*
		 * 변수 뒤에 커서 두고 오른쪽 클릭해서 
		 * refactor -> rename 으로 변경가능
		 */
		for(int i=1, j=0;i<11;i++) {
		//for(변수선언, 조건, 변수 증감설정)
			sum = sum + i;
		}
		System.out.println("sum : " + sum);
		int j = 0;
		for(;j<11;j++) {
			System.out.println("j : " + j);
		}
//		for(;;) {
//			System.out.println("무한반복");
		}
			//System.out.println("끝");
	}

