package ch06;

import java.awt.Frame;

//java.awt.Frame에 paramString의 결과갑을 출력하시오.
//paramString : 이벤트에 관련된 정보를 문자열로 반환
class Access5 extends Frame {
	public Access5() {
		//Frame 상속으로 protected 타입인 pramString 또한 사용 가능
		//protected 같은 package가 아닌경우, 반드시 상속을 통해서 가능
		System.out.println(paramString());
	}
}

public class AccessEx5 {
	public static void main(String[] args) {
		Access5 ad = new Access5();
	}

}
