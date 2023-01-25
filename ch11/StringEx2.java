package ch11;

import java.io.StreamTokenizer;

public class StringEx2 {

	public static void main(String[] args) {
		String str = "Java Programming";
		
		int len = str.length();
		System.out.println("len" + len);
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		char c1 = str.charAt(8);
		System.out.println("8번째 문자: " + c1);
		for(int i = 0;i<str.length();i++) {
			if(i%2==0)
				System.out.println(str.charAt(i));
			
		}
		//a는 몇번째 자리에 있는가
		//Java Programming
		int idx1 = str.indexOf('a');
		System.out.println("\n" + "idx1 :" + idx1);
		int idx2 = str.lastIndexOf('a');
		System.out.println("idx2: " + idx2);
		//a를 q로 변환 출력
		String str4 = str.replace('a', 'q');
		System.out.println(str4);
		for (int i = 0; i<str.length();i++) {
			if(str.charAt(i)=='a') {
				System.out.println('q');
			}else {
				System.out.println(str.charAt(i));
			}
		}//for
		//str을 반대로 출력 : chatAt,?
		
		System.out.println("-------------");
		for(int i = len -1;i>=0; i--) {
			System.out.println(str.charAt(i));
		}
		StringBuffer sb = new StringBuffer(str);
		System.out.println("\n" + sb.reverse());
		
		String str5 = "Java&JSP&Android&Iot&Spring";
		String str6[] = str5.split("&");
		for (int i = 0; i<str6.length; i++) {
			System.out.println(str6[i]);
		}
		String str7 = "         JSPStudy        ";
		System.out.println("***"+str7.trim()+"***");
		int idx3 =22;
		String str8 = String.valueOf(idx3);
		String str9 = idx3 + "";
		System.out.println(str9);
		
		
		
 		
		
	}
}
