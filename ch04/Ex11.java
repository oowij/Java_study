package ch04;

public class Ex11 {

	public static void main(String[] args) {
		//1~10사이의 짝수를 출력하시오.
		for(int i =0; i<11; i++) {
			if(i%2==0) {
				System.out.println(i + "\t");
			}
		}//for
		System.out.println("-----------------");
		for(int i =1;i<11;i++) {
			if(i%2!=0) {
				continue;
			}
			System.out.println(i +"\t");
		}
		System.out.println();
		
		// 1~20사이에 3의 배수와 식과 합을 출력하시오(continue)
		//3+6+9+12+15+18 == ooo
		int sum = 0;
		for(int i = 0;i<21;i++) {
			if(i%3!=0) {
				continue;
			}else {
				if(i>3) {
					System.out.println(" + ");
				}
			}
			sum += i;
			System.out.println(i);
		}
		System.out.println("=" + sum);
	}

}
