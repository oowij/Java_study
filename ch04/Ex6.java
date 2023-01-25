package ch04;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		/*
		 * 점수와 학년을 입력을 받아서 60이상이면 합격인데, 
		 * 4학년은 70점 이상 합격이다.
		 */
		Scanner sc = new Scanner(System.in);
		int score, year;
		System.out.println("점수를 입력하세요.(0~100): ");
		score = sc.nextInt();
		System.out.println("학년을 입력하세요.(1~4): ");
		year = sc.nextInt();
		
		if(score>100||year>4||year==0) {
			System.out.println("잘못입력하셨습니다.");
		}else if(score>=70&&year==4) {
			System.out.println("합격입니다.");
		}else if(score>=60&&year<4) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
	}

}
