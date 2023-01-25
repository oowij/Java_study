package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionEx4 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("ch10/Text.txt");
			int a; 
			while((a=fr.read())!=-1);{
				
			}
			//FileNotFoundException 상위클래스가 IOExeception
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
