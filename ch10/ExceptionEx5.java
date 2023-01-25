package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionEx5 {

   public static void main(String[] args) {
      try {
         FileReader fr = myReader("aaa.txt");
         
      } catch (Exception e) {
         
      }


   }
   public static FileReader myReader(String name)
         throws FileNotFoundException {
      FileReader fr = new FileReader(name);
      return fr;
   }

}