package ch04;

public class GuGuDan {

	public static void main(String[] args) {
		System.out.println();
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.print(j + " * " + i + " = " + String.format("%2d", i * j));
				System.out.print("   ");
			}
			System.out.println();
		}
	}
}