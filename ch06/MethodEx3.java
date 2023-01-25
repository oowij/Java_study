package ch06;

class Method3{
	void prn(int...arr/*배열로 인식*/) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}

//prn에 배열이 2번 중복이 됨.
//	void prn(int arr[]) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+"\t");
//			}
//	}
}

public class MethodEx3 {
	public static void main(String[] args) {
		Method3 mt = new Method3();
		mt.prn(1);
		mt.prn(1, 2);
		mt.prn(1, 2, 3);
		mt.prn(1, 2, 3, 4);
		mt.prn(1,4,5,6);
		System.out.printf("%s", "하하");
	}
	
}
