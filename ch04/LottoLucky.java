package ch04;

import java.util.Arrays;

public class LottoLucky {

	public static void main(String[] args) {
		int lotto[] = getLotto();
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i] + "\t");
		}
	}
	
	public static int[] getLotto() {
		int lotto[] = new int[6];
		//배열 밑에 항상 fpr문 있다.
		//중복로직 추가
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45) +1;//1~45
			
			for(int j =1;j<i;j++) {
				if(lotto[i] == lotto[j]) {
					i--;
				}
			}
		}
		Arrays.sort(lotto);//올림차순 정렬
		return lotto;
	}
}

//다른 방법
//	public static int[] getLotto() {
//		int lotto[] = new int[6];
//		//배열 밑에 항상 fpr문 있다.
//		//중복로직 추가
//		boolean isNumThere = false;
//		for (int i = 0; i < lotto.length; i++) {
//			isNumThere = false;
//			lotto[i] = (int)(Math.random()*45) +1;
//			for(int j=0;j<i;j++) {
//				if(lotto[i]==lotto[j]) {
//					isNumThere = true;
//				}
//			}
//			if(isNumThere) {
//				i--;
//			}
//			Arrays.sort(lotto);//올림차순 정렬
//			return lotto;
//		}
//	}	
//}
