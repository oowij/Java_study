package ch03;

public class Ex3 {
	
	public static void main(String[] args) {
		//배열 : 동일한 data type을 하나의 변수로 묶어 놓은 기능
		int a = 1;
		int b = 2;
		int c = 3;
		int arr[] = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
//		System.out.println(args[0]);
//		System.out.println(args[1]);
//		System.out.println(args[2]);
		//배열 밑에 항상 for문 있다.
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
